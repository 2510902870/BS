<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>findCourse</title>
</head>
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<h1>查询的课程</h1>
<label><s:property value="Dinformation"/></label>
<s:iterator value="list"  var="list">
<table class="kuang" style="float:left" width="23%">
<tr>
<td>
<%-- <embed width="200" height="200" src="<s:property value="#chinese.courseAddress"/>" autoplay="false"> --%>
<a href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#list.courseAddress"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>"><!--action进行显示  -->
<img  width="100%" height="180" alt="" src="<s:property value="#list.courseCoverAddress"/>"></a>
</td>
</tr>
<tr>
<td>课题：<s:property value="#list.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#list.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#list.courseGrade"/></td>
</tr>
<tr>
<td>是否通过审核：<s:property value="#list.coursecheck"/></td>
</tr>
<tr><td>
<a href="http://localhost:8888/BS/DeleteSubscribeAction?courseId=<s:property value="#list.courseId"/>">取消订阅</a></td></tr><!--根据courseId课程编号，对TC表进行删除  -->
<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
</table>
</s:iterator>
<s:property value="Sinformatica"/>
<s:debug></s:debug>
</body>
</html>