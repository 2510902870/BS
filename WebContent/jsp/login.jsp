<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a{TEXT-DECORATION:none}
</style>
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css"/>
</head>
 
<body>
<div id="login_frame">
 
    <p><img src="../images/admin.jpg" width=50 height=50></p>
 
    <form method="post"  action="LoginVerifyAction">
 
        <p><label class="label_input">账号</label><input type="text"  name="Susername" class="text_field"/></p>
        <p><label class="label_input">密码</label><input type="password" name="Spassword" class="text_field"/></p>
 		<p><input name="user" type="radio" value="student" checked="checked">学生
     		<input name="user" type="radio" value="teacher">教师
     		<input name="user" type="radio" value="admin">管理员
     		</p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="登录" />
            <a id="forget_pwd" href="studentRegister.jsp" >学生注册</a>
            &nbsp; &nbsp; &nbsp;
            <a id="forget_pwd" href="teacherRegister.jsp">教师注册</a>
        </div>
        <p>  <s:property value="information"/></p>
    </form>
</div>
 
</body>
</html>
