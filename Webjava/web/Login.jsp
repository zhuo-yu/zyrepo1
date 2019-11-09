<%@ page import="java.nio.file.Path" %><%--
  Created by IntelliJ IDEA.
  User: 卓
  Date: 2019/9/30
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%--<%--%>
<%--    String path=request.getContextPath();--%>
<%--    String basepath=request.getScheme()+"://"+request.getServerName()+"+"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>
    <div align="center">
        <!--判断登录密码-->
        <li><%String s= (String) session.getAttribute("fail");%></li>
        <%
            if(s!=null){
        %>
        <li><%=s%></li>
        <%
         session.removeAttribute("fail");   }
        %>
        <!--判断修改密码-->
        <li><%String pwd= (String) session.getAttribute("pwd");%></li>
        <%
            if(pwd!=null){
        %>
        <li><%=pwd%></li>
        <%
                session.removeAttribute("pwd");   }
        %>
        <!--判断用户注册-->
        <li><%String register= (String) session.getAttribute("register");%></li>
        <%
            if(register!=null){
        %>
        <li><%=register%></li>
        <%
                session.removeAttribute("register");   }
        %>
    </div>

    <div class="loginbox">
        <form action="LoginServlet" method="post">
             <ul>
                 <input type="hidden" name="submit" value="login">
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser" /></li>
                <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" /></li>
                <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><label><a href="User/Register.jsp">注册</a></label><label><a href="#">忘记密码？</a></label> </li>
              </ul>
        </form>
    </div>

</div>



<div class="loginbm" align="center">作者: Mr.宇  仅供学习交流，勿用于任何商业用途</div>


</body>

</html>
