package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.system.SysDictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import javax.naming.Name;

@Api(value = "数据字典接口", description = "提供数据字典接口的管理、查询功能")
public interface SysDictionaryControllerApi {

    @ApiOperation(value = "数据字典查询接口")
    @ApiImplicitParam(name = "type", value = "数据字典类型")
    public SysDictionary getByType(String type);
}
