<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input{
border-radius:10px;
}
table{
	font-size: 20px;
	font-weight:bold;
	/* border:2px solid #F00  */  
	
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scoresRanking</title>
</head>
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<h1>查看班级学生积分排名</h1>
<form action="TGetScoresAction" method="post"> 
 <input type="hidden" name="loginname" value="<%=request.getParameter("loginname") %>"/>
<input type="hidden" name="userclass" value="<%=request.getParameter("userclass") %>"/>
<table style="margin:0 auto; width:250;" >
<tr height="50">
<td><label>学  校</label></td>
<td><input name="schoolName" type="text"></td>
</tr>
<tr height="50">
<td><label>班  级</label></td>
<td><input name="classGrade" type="text"></td>
</tr>
<tr height="50">
<td  align="center"><input type="reset"  value="reset"></td>
<td align="right"><input type="submit"  value="Serach"></td>
</tr>
</table>
</form>
</body>
</html>