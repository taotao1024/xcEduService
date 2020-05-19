package com.xuecheng.framework.domain.cms.ext;

import com.xuecheng.framework.domain.cms.CmsTemplate;


public class CmsTemplateExt extends CmsTemplate {

    //模版内容
    private String templateValue;

    public String getTemplateValue() {
        return templateValue;
    }

    public void setTemplateValue(String templateValue) {
        this.templateValue = templateValue;
    }

    @Override
    public String toString() {
        return "CmsTemplateExt{" +
                "templateValue='" + templateValue + '\'' +
                '}';
    }
}
