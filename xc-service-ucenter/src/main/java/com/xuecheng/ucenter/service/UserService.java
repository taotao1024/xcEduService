package com.xuecheng.ucenter.service;

import com.xuecheng.framework.domain.ucenter.XcCompanyUser;
import com.xuecheng.framework.domain.ucenter.XcMenu;
import com.xuecheng.framework.domain.ucenter.XcUser;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.ucenter.dao.XcCompanyUserRepository;
import com.xuecheng.ucenter.dao.XcMenuMapper;
import com.xuecheng.ucenter.dao.XcUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class UserService {

    @Autowired
    XcUserRepository xcUserRepository;

    @Autowired
    XcMenuMapper xcMenuMapper;

    @Autowired
    XcCompanyUserRepository xcCompanyUserRepository;

    //根据账号查询xcUser信息
    public XcUser findXcUserByUsername(String username) {
        return xcUserRepository.findByUsername(username);
    }

    /**
     * 根据账号查询用户信息
     *
     * @param username 账号
     * @return
     */
    public XcUserExt getUserExt(String username) {
        //根据账号查询xcUser信息
        XcUser xcUser = this.findXcUserByUsername(username);
        if (xcUser == null) {
            return null;
        }
        //用户id
        String userId = xcUser.getId();
        //查询用户的所有权限
        List<XcMenu> xcMenus = xcMenuMapper.selectPermissionByUserId(userId);
        //根据用户id查询用户所属公司id
        XcCompanyUser xcCompanyUser = xcCompanyUserRepository.findByUserId(userId);
        //取到用户的公司id
        String companyId = null;
        if (xcCompanyUser != null) {
            companyId = xcCompanyUser.getCompanyId();
        }
        XcUserExt xcUserExt = new XcUserExt();
        BeanUtils.copyProperties(xcUser, xcUserExt);
        //企业信息
        xcUserExt.setCompanyId(companyId);
        //设置权限
        xcUserExt.setPermissions(xcMenus);
        return xcUserExt;

    }

}
