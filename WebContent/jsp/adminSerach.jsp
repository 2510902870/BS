<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input{
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
table{
	font-size: 20px;
	font-weight:bold;
	/* border:2px solid #F00  */  
	
}
</style>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminSerach</title>
</head>
<body  style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed;">
<label style="float:left;font-size:30px;font-weight:bold">查看信息</label>
<%-- <label style="float:right"><a href="http://localhost:8888/BS/ReturnHomeAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">返回主页</a>
</label> --%>
<br/><br/><br/>
<form action="AdminSerachAction" method="post"> 
<input type="hidden" name="loginname" value="admin"/>
<input type="hidden" name="username" value="123456"/>
<table  style="margin:0 auto; width:250;" >
<tr height="50">
<td><label>学  校</label></td>
<td><input name="schoolName" type="text"></td>
</tr>
<tr height="50">
<td><label>编  号</label></td>
<td><input name="Id" type="text"></td>
</tr>
<tr height="50">
<td><label>类  别</label></td>
<td><input name="user" type="radio" value="student" checked="checked">学生
     		<input name="user" type="radio" value="teacher">教师
</td>
</tr>
<tr height="50">
<td  align="center"><input type="reset"  value="reset"></td>
<td align="right"><input type="submit"  value="Serach"></td>
</tr>
</table>
<br/><br/><br/><br/>
</form>


<s:iterator value="teacher"  var="teacher">
<table class="personal" style="margin:0 auto; width:250;" >
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


<s:iterator value="student"  var="student">
<table class="personal" style="margin:0 auto; width:250;" >
<tr>
<td>学号：</td>
<td><s:property value="#student.studentId"/></td>
</tr>
<tr>
<td>姓名：</td>
<td><s:property value="#student.studentName"/></td>
</tr>
<tr>
<td>登录用户：</td>
<td><s:property value="#student.Susername"/></td>
</tr>
<tr>
<td>登录密码：</td>
<td><s:property value="#student.Spassword"/></td>
</tr>
<tr>
<td>年龄</td>
<td><s:property value="#student.studentAge"/></td>
</tr>
<tr>
<td>班级</td>
<td><s:property value="#student.grade"/></td>
</tr>
<tr>
<td>就读学校：</td>
<td><s:property value="#student.schoolName"/></td>
</tr>
</table >
</s:iterator>

<s:debug></s:debug>
</body>
</html>