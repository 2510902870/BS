<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<style>
a{
TEXT-DECORATION:none;
bgcolor:red;
}
.personal{
	width:400px;
	height:400px;
	font-size:18px;
	font-style:nomal;
	font-weight:bold;
	border-radius:10px;
	 border:2px solid #ccffff;
	margin:0 auto;
}
</style>
<link rel="stylesheet" type="text/css" href="http://localhost:8888/BS/css/daohang.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生个人信息中心</title>
</head>
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<label style="float:left;font-size:30px;font-weight:bold">学生个人中心</label>
<label style="float:right"><a href="http://localhost:8888/BS/ReturnHomeAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">返回主页</a>
</label>
<br/><br/><br/>
<s:property value="Reinformation"/>
<form action="">
<header>
<div class="menu">
<ul  class="menubar">
<li class="menu-value">
<a  href="http://localhost:8888/BS/SandTinfoAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">个人信息</a>
</li>
<li class="">
<a href="http://localhost:8888/BS/StudentCourseAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">我的课程</a>
</li>
<li class="">
<a href="http://localhost:8888/BS/jsp/alterPassword.jsp?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">修改个人信息</a>
</li>
<li class="">
<a href="http://localhost:8888/BS/SGetScoresAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">积分排名</a><!--  同一个班级的同学进行排名-->
</li>
<li class="">
<a href="http://localhost:8888/BS/jsp/studentReport.jsp?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">举  报</a>
</li>
</ul>
</div>
</header>


<s:property value="information"/>
<table style=" border:1px solid red;margin:0 auto;width:400px; font-size:25px; font-weight:bolder; border-collapse:collapse;" >
<s:iterator value="list" var="list">
<tr style="border:1px solid red;"> 
<td ><s:property value="#list.studentId"/></td><!--学号  -->
<td ><s:property value="#list.studentName"/></td><!-- 姓名 -->
<td ><s:property value="#list.scores"/>学分</td><!--学分  -->
</tr>
</s:iterator>
</table>
<s:iterator value="student"  var="students">
<table class="personal">
<tr>
<td>学生学号：</td>
<td><s:property value="#students.studentId"/></td>
</tr>
<tr>
<td>学生姓名：</td>
<td><s:property value="#students.studentName"/></td>
</tr>
<tr>
<td>登录用户：</td>
<td><s:property value="#students.Susername"/></td>
</tr>
<tr>
<td>登录密码：</td>
<td><s:property value="#students.Spassword"/></td>
</tr>
<tr>
<td>学生年龄</td>
<td><s:property value="#students.studentAge"/></td>
</tr>
<tr>
<td>就读年级：</td>
<td><s:property value="#students.grade"/></td>
</tr>
</table>
</s:iterator>

</form>
 <s:debug></s:debug>
</body>
</html>