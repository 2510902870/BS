<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
input{
border-radius:10px;
}
table{
	font-size: 20px;
	font-weight:bold;
 	border:2px solid #ccffff; 
	width:300px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>studentReport</title>
</head>
<body  style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<h1>举报违规课程</h1><h5>诚信举报,抵制虚假举报</h5>
<form action="Stu_ReportAction" method="post">
<input type="hidden" name="loginname" value="<%=request.getParameter("loginname") %>"/>
<input type="hidden" name="userclass" value="<%=request.getParameter("userclass") %>"/>
<table style="margin:0 auto;">
<tr height="60">
<td>举报人学号</td>
<td><input type="text" name="studentId"></td>
</tr>
<tr height="60">
<td>举报人姓名</td>
<td><input type="text" name="studentName"></td>
</tr>
<tr height="60">
<td>举报课程名</td>
<td><input type="text" name="courseTitle"></td>
</tr>
<tr height="60">
<td>举报理由</td>
<td><select name="reasons">
<option value="色情" selected="selected">色情</option>
<option value="言语辱骂">言语辱骂</option>
<option value="传播不良思想">传播不良思想</option>
<option value="涉赌">涉赌</option>
</select></td>
</tr>
<tr height="60">
<td>附加信息</td>
<td><textarea rows="2" cols="15" name="addInformation"></textarea></td>
</tr>
<tr height="60">
<td><input type="reset" value="重新输入"></td>
<td align="right"><input type="submit" value="确认举报" ></td>
</tr>
</table>
</form>
</body>
</html>