package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@Api(value = "CMS配置管理接口", description = "CMS配置管理接口:提供页面数据模型页面的管理、查询接口")
public interface CmsConfigControllerApi {
    @ApiOperation(value = "根据id查询CMS配置信息")
    @ApiImplicitParam(name = "id", value = "模板id", required = true, paramType = "path", type = "int")
    public CmsConfig getmodel(String id);
}
