package com.xuecheng.auth.service;

import com.xuecheng.auth.bean.UserJwt;
import com.xuecheng.auth.client.UserClient;
import com.xuecheng.framework.domain.ucenter.XcMenu;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户名密码认证
 * Security 自动调用的方法
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if (authentication == null) {
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if (clientDetails != null) {
                //密码
                String clientSecret = clientDetails.getClientSecret();
                return new User(username, clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        //账号不存在
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        //远程调用
        XcUserExt userExt = userClient.getUserExt(username);
        if (null == userExt) {
            //用户不存在
            return null;
        }

        //权限先用静态的
        //userExt.setPermissions(new ArrayList<XcMenu>());
        //用户权限，这里暂时使用静态数据，最终会从数据库读取

        //取出正确密码（hash值）
        String password = userExt.getPassword();

        //从数据库获取权限
        List<XcMenu> permissions = userExt.getPermissions();
        if (null == permissions) {
            permissions = new ArrayList<>();
        }
        List<String> user_permission = new ArrayList<>();
        //遍历设置权限
        permissions.forEach(item -> user_permission.add(item.getCode()));

        //使用静态的权限表示用户所有权限
        //user_permission.add("course_get_baseinfo");//查询课程信息
        //user_permission.add("course_find_pic");//图片查询

        //权限
        String user_permission_string = StringUtils.join(user_permission.toArray(), ",");

        UserJwt userDetails = new UserJwt(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList(user_permission_string));

        userDetails.setId(userExt.getId());
        userDetails.setUtype(userExt.getUtype());//用户类型
        userDetails.setCompanyId(userExt.getCompanyId());//所属企业
        userDetails.setName(userExt.getName());//用户名称
        userDetails.setUserpic(userExt.getUserpic());//用户头像

       /* UserDetails userDetails = new org.springframework.security.core.userdetails.User(username,
                password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(""));*/
//              AuthorityUtils.createAuthorityList("course_get_baseinfo","course_get_list"));
        return userDetails;
    }
}
