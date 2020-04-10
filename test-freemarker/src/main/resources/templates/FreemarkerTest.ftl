<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World!</title>
</head>
<body>
<#-- 我是freemaker的注释 -->
Hello ${name}!<br/>
数组数据个数 :${stus?size}<br/>

<#--表格-->
<table border="1" style="background-color: aqua">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
    <#--变量List-->
    <#list stus as stu>
        <tr>
            <td>${stu_index + 1}</td>
            <td <#if stu.name =='张三'>style="background:red;"</#if> >${stu.name}</td>
            <td <#if stu.age gt 18>style="background: yellow" </#if> >${stu.age}</td>
            <td>${stu.mondy}</td>
        </tr>
    </#list>
</table>
<br/>

<#--遍历Map-->
<b>取出map数据 a.在中括号中填写map的key</b><br/>

<b>取出map数据 b.在map后边.key</b><br/>
<#--设置默认值 (xxx)！"默认值"-->
输出stu1的学生信息：<br/>
姓名：${(stuMap['stu1'].name)!"默认值"}<br/>
姓名：${stuMap.stu1.name}<br/>
年龄：${stuMap['stu1'].age}<br/>
年龄：${stuMap.stu1.age}<br/><br/>

遍历Map输出两个学生信息：<br/>
<table border="1" style="background-color: aquamarine">
    <tr>
        <td>序号</td>
        <td>map:list</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
    <#--key相当于map中的一行list数据-->
    <#list stuMap?keys as key>
        <tr>
            <td>${key_index + 1}</td>
            <td>${key}</td>
            <td>${stuMap[key].name}</td>
            <td>${stuMap[key].age}</td>
            <td>${stuMap[key].mondy}</td>
        </tr>
    </#list>
</table>
</br>

<table border="1" style="background-color: deepskyblue">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>出生日期</td>
        <td>钱包</td>
        <td>最好的朋友</td>
        <td>朋友个数</td>
        <td>朋友列表</td>
    </tr>
    <#--空置处理-->
    <#if stus??>
        <#list stus as stu>
            <tr>
                <td>${stu.name!''}</td>
                <td>${stu.age}</td>
                <td>${(stu.birthday?date)!''}</td>
                <td>${stu.mondy}</td>
                <td>${(stu.bestFriend.name)!''}</td>
                <td>${(stu.friends?size)!0}</td>
                <td>
                    <#if stu.friends??>
                        <#list stu.friends as firend>
                            ${firend.name!''}<br/>
                        </#list>
                    </#if>
                </td>
            </tr>
        </#list>
    </#if>
</table>

<#assign text="{'bank':'工商银行','account':'10101920201920212'}" />
<#assign data=text?eval />
开户行：${data.bank} 账号：${data.account}
</body>
</html>