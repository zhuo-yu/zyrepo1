<%--
  Created by IntelliJ IDEA.
  User: 卓
  Date: 2019/10/5
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <!--添加JQuery-->
    <script type="text/JavaScript" src="/js/jquery.js"></script>
    <!--声明JQuery代码域-->
    <script type="text/javascript">
        $(function () {
            //校验密码修改
            $("#fm").submit(function () {
                if($("#newpwd").val()==""){
                    alert("新密码不能为空");
                    return false;
                }else if($("#cfpwd").val()==""){
                    alert("确认密码不能为空");
                    return false;
                }else if($("#newpwd").val()!==$("#cfpwd").val()){
                    alert("新密码与确认密码不一致");
                    return false;
                }else if($("#newname").val()==""){
                    alert("账户名不能为空");
                    return false;
                }else if($("#age").val()>120){
                    alert("年龄不符合格式");
                    return false;
                }else if(!($("#age").value() >= 0)){
                    alert("年龄不符合格式")
                    return false;
                }else{
                    return true;
                }
            })
        })
    </script>
</head>

<body>

<div class="place">

</div>

<div class="formbody" >

    <div class="formtitle"><span>用户注册</span></div>
    <form action="/Web_Manager_war_exploded/LoginServlet" METHOD="post" id="fm">
        <ul class="forminfo">
            <input type="hidden" name="submit" value="register">
            <li><label>账户名</label><input name="newname" id="newname" type="text" class="dfinput" />(必填)</li>
            <li><label>新密码</label><input name="newpwd" id="newpwd" type="text" class="dfinput" />(必填)</li>
            <li><label>确认密码</label><input name="" id="cfpwd" type="text" class="dfinput" />(必填)</li>
            <li><label>性别</label>
                男<input name="sex" id="man" value="1" type="radio" checked="checked"/>&emsp;&emsp;
                女<input name="sex" id="woman" value="0" type="radio"  />
            </li>
            <li><label>年龄</label><input name="age" id="age" type="text" class="dfinput" οninput="value=value.replace(/[^\d]/g,'')" /><i></i></li>
            <li><label>出生年月</label><input name="birth" id="birth" type="text" class="dfinput" />例如：2019-10-1</li>
            <li><label>&nbsp;</label><input type="submit" value="确认注册" class="btn"></li>
        </ul>
    </form>
</div>


</body>

</html>
