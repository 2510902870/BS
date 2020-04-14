<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
a{TEXT-DECORATION:none}
input{
border-radius:10px;
}
td{
font-size:18px;
/*  border:1px solid #F00;  */
}
.kuang{
  border:2px solid #ccffff; 
margin:8px;
padding:0px;
border-radius:10px;
}
.tr{
border-radius:10px;
margin:8px;
padding:0px;
 border:2px solid black; 
}
.label{
font-size:18px;
font-weight:bold;
font-style:italic;
color:black;
}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>播放视频页面</title>
</head>
<!-- 修改大小 -->
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<embed width="100%"  height="500" src="<s:property value="courseAddress"/>" autoplay="false">



<%-- <table>
<tr>
<td  rowspan="2" colspan="2"><img width="100" height="100" src="http://localhost:8888/BS/images/admin.jpg" /></td>
<td>姓    名</td>
<td><s:property value="teacher.teacherName" /> </td>
</tr>
<tr>
<td>编    号</td>
<td><s:property value="teacher.teacherId"/></td>
</tr>
<tr>
<td colspan="4">相关视频</td>
</tr>
<s:iterator value="courses"  var="courses">
<tr>
<td rowspan="2" colspan="2"><img width="150" height="100" src="<s:property value="#courses.courseCoverAddress"/>"></td><!-- 封面 -->
<td colspan="2"><a href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#courses.courseAddress"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>">
<s:property value="#courses.courseTitle"/></a></td><!-- 标题 -->
</tr>
<tr>
<td><s:property value="#courses.courseClass"/></td><!--  courseClass分类-->
<td><s:property value="#courses.courseDifficulty"/></td><!--courseDifficulty难度系数-->
</tr>
</s:iterator>
</table> --%>
<br/><br/><br/><br/>
<form action="CommentAction" method ="post">
<input type="hidden" name="courseAddress" value="<s:property value="courseAddress"/>">
<input type="hidden" name="userclass" value="<s:property value="user"/>">
<input type="hidden" name="loginname" value="<s:property value="loginname"/>">
<input type="hidden"  name="comments"  value="<s:property value="comments"/>">
<table width="100%">
<tr>
<td width="20%"> <label class="label">评 论 </label></td>
<td><textarea name="studentContext" rows="2" cols="50"></textarea><input type="submit" value="提交">
</td>
</tr>
<tr>
<td colspan="2"><label class="label">更多评论</label></td>
</tr>
<s:iterator value="comments" var="comments">
<tr>
<td width="200" height="40"> <label>第 <s:property value="#comments.commentId"/> 楼 </label><br/> 
<s:property value="#comments.studentName"/><s:property value="#comments.time"/></td>
<td height="40">
<label><s:property value="#comments.studentContext"/></label>
<a style="margin-right:50px;" href="http://localhost:8888/BS/TadmireAction?loginname=<s:property value="loginname"/>&userclass=<s:property value="user"/>&courseAddress=<s:property value="courseAddress"/>&studentId=<s:property value="#comments.studentId"/>&teacherId=<s:property value="#comments.teacherId"/>&commentId=<s:property value="#comments.commentId"/>" >
点赞<s:property value="#comments.priase"/></a>
<a  href="">回复</a>
</td>
</tr>
</s:iterator>
</table>
</form>
<s:debug></s:debug>
</body>
</html>