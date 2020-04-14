<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/register.css" />
<title>studentRegister.jsp</title>
</head>
<body>
	<div id="register_frame">
		<h3>学生注册页面</h3>
		<form name="StudentRegister" action="StudentRegisterAction"
			method="post">
			<p>
				<label class="label_input">学号:&nbsp;&nbsp;</label><input type="text"
					name="studentId" class="text_field">
			</p>
			<p>
				<label class="label_input">姓名:&nbsp;&nbsp;</label><input type="text"
					name="studentName" class="text_field">
			</p>
			<p>
				<label class="label_input">账号:&nbsp;&nbsp;</label><input type="text"
					name="Susername" class="text_field">
			</p>
			<p>
				<label class="label_input">密码:&nbsp;&nbsp;</label><input type="password"
					name=" Spassword" class="text_field">
			</p>
			<p>
				<label class="label_input">年龄:&nbsp;&nbsp;</label><input type="text"
					name="studentAge" class="text_field">
			</p>
			<p>
				<label class="label_input">学校:&nbsp;&nbsp;</label><input type="text"
					name="schoolName" class="text_field">
			</p>
			<p>
				<label class="label_input">年级:&nbsp;&nbsp;</label><input type="text"
					name="grade" class="text_field">
			</p>
			<p>
				<input type="hidden"
					name="scores"  value="0" class="text_field">
			</p>
			<div id="register_control">
				<input type="submit" id="register" value="注册" />
			</div>
		</form>
	</div>
</body>
</html>