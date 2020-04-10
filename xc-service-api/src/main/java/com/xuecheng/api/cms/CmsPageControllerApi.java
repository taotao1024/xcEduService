package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.cms.response.CmsPostPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.persistence.Id;

@Api(value = "CMS页面管理接口", description = "CMS页面管理接口:负责页面的增、删、改、查")
public interface CmsPageControllerApi {

    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("新增页面")
    @ApiImplicitParam(name = "CmsPage", value = "页面信息")
    public CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("根据页面id查询页面信息")
    @ApiImplicitParam(name = "id", value = "页面id", required = true, paramType = "path", dataType = "int")
    public CmsPage findById(String id);

    @ApiOperation("修改页面")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "页面id", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "CmsPage", value = "页面信息")
    })
    public CmsPageResult edit(String id, CmsPage cmsPage);

    @ApiOperation("根据id删除页面")
    @ApiImplicitParam(name = "id", value = "页面id", required = true, paramType = "path", dataType = "int")
    public ResponseResult delete(String id);

    @ApiOperation(value = "页面发布")
    @ApiImplicitParam(name = "id", value = "页面id", required = true, paramType = "path", dataType = "int")
    public ResponseResult post(String pageId);

    @ApiOperation("保存页面")
    public CmsPageResult save(CmsPage cmsPage);

    @ApiOperation("一键发布页面")
    public CmsPostPageResult postPageQuick(CmsPage cmsPage);
}
