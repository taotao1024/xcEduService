package com.xuecheng.framework.domain.cms.ext;

import com.xuecheng.framework.domain.cms.CmsPage;

public class CmsPageExt extends CmsPage {
    private String htmlValue;

    public String getHtmlValue() {
        return htmlValue;
    }

    public void setHtmlValue(String htmlValue) {
        this.htmlValue = htmlValue;
    }

    @Override
    public String toString() {
        return "CmsPageExt{" +
                "htmlValue='" + htmlValue + '\'' +
                '}';
    }
}
