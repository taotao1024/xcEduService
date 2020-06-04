package com.xuecheng.framework.domain.order.response;

import com.xuecheng.framework.domain.order.XcOrdersPay;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.api.ResultCode;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class PayOrderResult extends ResponseResult {
    public PayOrderResult(ResultCode resultCode) {
        super(resultCode);
    }
    public PayOrderResult(ResultCode resultCode,XcOrdersPay xcOrdersPay) {
        super(resultCode);
        this.xcOrdersPay = xcOrdersPay;
    }
    private XcOrdersPay xcOrdersPay;
    private String orderNumber;

    //当tradeState为NOTPAY（未支付）时显示支付二维码
    private String codeUrl;
    private Float money;


}
