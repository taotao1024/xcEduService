package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface XcMenuMapper {
    /**
     * 根据用户id查询用户权限
     */
    public List<XcMenu> selectPermissionByUserId(String userid);
}
