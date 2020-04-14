<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
a{TEXT-DECORATION:none}
.kuang{
 border:2px solid #ccffff;
margin:8px;
padding:0px;
border-radius:10px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>findCourse</title>
</head>
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<h1>查 询 结 果</h1>
<s:property value="Pinformation"/><br/>
<s:property value="Rinformation"/><br/>
<s:iterator value="list"  var="list">
<table class="kuang" style="float:left" width="22%">
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
<td>难度系数：<s:property value="#list.courseDifficulty"/></td>
</tr>
<tr><td>
<a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#list.courseId"/>&loginname=<s:property value="loginname"/>">
<s:property value="Linformation"/>
</a>
<br/></td></tr>
<tr height="50">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
</table>
</s:iterator>
<s:property value="Sinformatica"/>




<s:iterator value="adminlist"  var="adminlist">
<table class="kuang" style="float:left" width="24%">
<tr>
<td colspan="2">
<%-- <embed width="200" height="200" src="<s:property value="#chinese.courseAddress"/>" autoplay="false"> --%>
<a href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#adminlist.courseAddress"/>"><!--action进行显示  -->
<img  width="100%" height="180" alt="" src="<s:property value="#adminlist.courseCoverAddress"/>"></a>
</td>
</tr>
<tr>
<td colspan="2">课题：<s:property value="#adminlist.courseTitle"/></td>
</tr>
<tr>
<td colspan="2">作者：<s:property value="#adminlist.courseAuthor"/></td>
</tr>
<tr>
<td colspan="2">年级：<s:property value="#adminlist.courseGrade"/></td>
</tr>
<tr>
<td colspan="2">是否通过审核：<s:property value="#adminlist.coursecheck"/></td>
</tr>
<tr><td>
<a href="http://localhost:8888/BS/PassCourseAction?courseId=<s:property value="#adminlist.courseId"/>">审核通过</a>
</td>
<td align="center">
<a href="http://localhost:8888/BS/RefuseCourseAction?courseId=<s:property value="#adminlist.courseId"/>">拒绝通过</a>
</td></tr>
<tr height="50">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
</table>
</s:iterator>
</body>
</html>