package com.xuecheng.api.ucenter;

import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户中心
 */
@Api(value = "用户中心", description = "用户中心管理")
public interface UcenterControllerApi {
    /**
     * 根据用户账号查询用户信息
     *
     * @param username 用户账号
     * @return
     */
    @ApiOperation("根据用户账号查询用户信息")
    public XcUserExt getUserExt(String username);
}
