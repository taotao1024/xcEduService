package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 14:59
 **/
@Data
@ToString
public class QueryPageRequest {
    //接收页面查询的查询条件
    @ApiModelProperty("站点id")
    private String siteId;
    @ApiModelProperty("页面id")
    private String pageId;
    @ApiModelProperty(" 页面名称")
    private String pageName;
    @ApiModelProperty("别名")
    private String pageAliase;
    @ApiModelProperty("模版id")
    private String templateId;

}
