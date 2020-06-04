package com.xuecheng.framework.domain.cms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@ToString
@Document(collection = "cms_config")
public class CmsConfig {

    @Id
    @ApiModelProperty("模板id")
    private String id;
    @ApiModelProperty("模板名称")
    private String name;

    private List<CmsConfigModel> model;

}
