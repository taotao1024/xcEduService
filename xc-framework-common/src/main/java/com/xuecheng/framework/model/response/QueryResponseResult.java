package com.xuecheng.framework.model.response;

import com.xuecheng.framework.model.response.api.ResultCode;
import com.xuecheng.framework.model.response.bean.QueryResult;
import lombok.Data;
import lombok.ToString;

/**
 * 查询响应结果
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/3/24
 */
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    /**
     * 查询结果实体
     */
    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }

}
