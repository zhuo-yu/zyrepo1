<%--
  Created by IntelliJ IDEA.
  User: 卓
  Date: 2019/10/4
  Time: 19:16
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
                }else{
                    return true;
                }
            })
        })
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改密码</span></div>
    <form action="/Web_Manager_war_exploded/LoginServlet" METHOD="post" id="fm" target="_top">
    <ul class="forminfo">
            <input type="hidden" name="submit" value="update">
        <li><label>新密码</label><input name="newpwd" id="newpwd" type="text" class="dfinput" /><i></i></li>
        <li><label>确认密码</label><input name="" id="cfpwd" type="text" class="dfinput" /><i></i></li>
<%--        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存"/></li>--%>
        <li><label>&nbsp;</label><input type="submit" value="确认保存" class="btn"></li>
    </ul>
    </form>

</div>


</body>

</html>
