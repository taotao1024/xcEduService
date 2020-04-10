package com.xuecheng.test.freemarker.model;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;


/**
 * @author Administrator
 * @version 1.0
 * @create 2018-06-13 8:24
 **/
@Data
@ToString
public class Student {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("钱包")
    private Float mondy;
    @ApiModelProperty("朋友列表")
    private List<Student> friends;
    @ApiModelProperty("最好的朋友")
    private Student bestFriend;
}
