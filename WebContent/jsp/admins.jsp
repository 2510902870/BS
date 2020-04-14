<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<style>
td{
border:1px solid black;
}
a{TEXT-DECORATION:none}
</style>
<head>
<link rel="stylesheet" type="text/css" href="http://localhost:8888/BS/css/daohang.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin</title>
</head>
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">

<label style="float:left;font-size:30px;font-weight:bold">管理员个人中心</label>
<%--  <label style="float:right"><a  href="http://localhost:8888/BS/ReturnHomeAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">返回主页</a></label> 
 --%>
<br/><br/><br/><br/>
<div class="menu">
	<ul class="menubar">
		<li class="menu-value" ><a href="http://localhost:8888/BS/AdmincheckCourseAction_execute">待审核课程</a></li>
		<li class="" ><a href="http://localhost:8888/BS/GetTeacherInfoAction">教师统计信息</a></li>
				<li class="" ><a href="http://localhost:8888/BS/jsp/adminSerach.jsp">查询学生信息</a></li>
				<li class="" ><a href="http://localhost:8888/BS/jsp/adminSerach.jsp">查询教师信息</a></li>
		<li class="" ><a href="http://localhost:8888/BS/AdmincheckCourseAction_mypost">我的邮件</a></li>
	</ul>
</div>
<br/><br/>
<table style=" border:1px solid red;margin:0 auto;width:1000px; font-size:25px; font-weight:bolder;	border-collapse:collapse;" >

<thead style="background:#cff">
<tr>
<s:iterator value="list5" id="li5">
<td align="center"><s:property value="li5"/></td>
</s:iterator>
</tr>
</thead>

<s:iterator value="mypost" var="mypost">
<tbody style="background:#fcf">
<tr style="border:1px solid red;"> 
<td ><s:property value="#mypost.reportId"/></td>
<td ><s:property value="#mypost.studentId"/></td>
<td ><s:property value="#mypost.studentName"/></td>
<td ><s:property value="#mypost.courseTitle"/></td>
<td ><s:property value="#mypost.reason"/></td>
<td ><s:property value="#mypost.addInformation"/></td>
</tr>
</tbody>
</s:iterator>
</table>


 <table style=" border:1px solid red;margin:0 auto;width:1000px; font-size:25px; font-weight:bolder;	border-collapse:collapse;" >


<thead style="background:#cff">
<s:if test="%{list2!=null}">
<tr>
<td align="center"><s:property value="th1"/></td>
<s:iterator value="list2" id="li2"><!-- list2为科目类别 -->
<td align="center"><s:property value="li2"/></td>
</s:iterator>
</tr>
</s:if>
</thead>


<tbody style="background:#fcf">
<s:if  test="%{list3!=null}" >
<tr>
<td align="center"><s:property value="th2"/></td>
<s:iterator value="list3" id="li3">
<td align="center"><s:property value="li3"/></td>
</s:iterator>
</tr>
</s:if>
<s:if test="%{list4!=null}">
<tr>
<td align="center"><s:property value="th3"/></td>
<s:iterator value="list4" id="li4">
<td align="center"><s:property value="li4"/></td>
</s:iterator>
</tr>
</s:if>
</tbody>
</table> 


<s:debug></s:debug>
</body>
</html>