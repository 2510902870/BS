<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<style>
a{TEXT-DECORATION:none}
.kuang{
 border:2px solid #ccffff;
margin:8px;
padding:0px;
border-radius:10px;
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
<title>教师个人信息</title>
</head>
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<label style="float:left;font-size:30px;font-weight:bold">教师个人中心</label>
 <label style="float:right"><a  href="http://localhost:8888/BS/ReturnHomeAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">返回主页</a>
</label>
<br/><br/><br/>

<div class="menu"> 
<ul  class="menubar">
<li class="menu-value" >  <a  href="http://localhost:8888/BS/SandTinfoAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">个人信息</a>
</li>
<li class="" ><a href="http://localhost:8888/BS/TeachersCourse?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">我的课程</a>
</li>
<li class="" ><a href="http://localhost:8888/BS/jsp/uploadvedio.jsp?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">上传视频</a>
</li>
<li class="" ><a href="http://localhost:8888/BS/jsp/alterPassword.jsp?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">修改密码</a>
</li>
<li class="" ><a href="http://localhost:8888/BS/jsp/scoresRanking.jsp?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">查看学生积分排名</a>
</li>
</ul>
</div>
 
<br/><br/>

<s:iterator value="teacher"  var="teacher">
<table class="personal" >
<tr>
<td>教师编号：</td>
<td><s:property value="#teacher.teacherId"/></td>
</tr>
<tr>
<td>教师姓名：</td>
<td><s:property value="#teacher.teacherName"/></td>
</tr>
<tr>
<td>登录用户：</td>
<td><s:property value="#teacher.Tusername"/></td>
</tr>
<tr>
<td>登录密码：</td>
<td><s:property value="#teacher.Tpassword"/></td>
</tr>
<tr>
<td>任职类别</td>
<td><s:property value="#teacher.teacherClass"/></td>
</tr>
<tr>
<td>教师性别</td>
<td><s:property value="#teacher.teacherSex"/></td>
</tr>
<tr>
<td>任职学校：</td>
<td><s:property value="#teacher.schoolName"/></td>
</tr>
<tr>
<td>教师年龄：</td>
<td><s:property value="#teacher.teacherAge"/></td>
</tr>
</table >
</s:iterator>



<s:iterator value="listcourses"  var="course">
<table class="kuang"  style="float:left" width="23%">
<tr>
<td>
<%-- <embed height="150" src="<s:property value="#course.courseAddress"/>" autoplay="false"> --%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#course.courseAddress"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">
<img alt="" width="100%" height="180" src="<s:property value="#course.courseCoverAddress"/>"></a>

</td>
</tr>
<tr>
<td>课题：<s:property value="#course.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#course.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#course.courseGrade"/></td>
</tr>
<tr>
<td>是否通过审核：<s:property value="#course.coursecheck"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/jsp/TDeleteCourse?courseId=<s:property value="#course.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>"
onclick="javascript:return confirm('确认删除？');">删除该课程</a></td><!-- 传人courseId将课程删除 -->
</tr>
<tr height="40">
<td>
<label></label>
</td>
</tr>
</table>
</s:iterator>
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
<s:debug></s:debug>
</body>
</html>
