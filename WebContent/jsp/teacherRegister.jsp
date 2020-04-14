<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/teacherRegister.css" />
<title>TeacherRegisterPage</title>
</head>
<body>
	<div id="teacherRegister_frame">
		<h3>教师注册页面</h3>
		<form name="TeacherRegister" action="TeacherRegisterAction" method="post">
			<p>
				<label class="label_input">教师编号:&nbsp;&nbsp;</label><input type="text"
					name="teacherId" class="text_field">
			</p>
			<p>
				<label class="label_input">教师姓名:&nbsp;&nbsp;</label><input type="text"
					name="teacherName" class="text_field">
			</p>
			<p>
				<label class="label_input">用户名:&nbsp;&nbsp;</label><input type="text"
					name="Tusername" class="text_field">
			</p>
			<p>
				<label class="label_input">登录密码:&nbsp;&nbsp;</label><input type="text"
					name=" Tpassword" class="text_field">
			</p>
			<p>
				<label class="label_input">教师类别:&nbsp;&nbsp;</label><input type="text"
					name="teacherClass" class="text_field">
			</p>
			<p>
				<label class="label_input">性别:&nbsp;&nbsp;</label><input type="text"
					name="teacherSex" class="text_field">
			</p>
			<p>
				<label class="label_input">学校:&nbsp;&nbsp;</label><input type="text"
					name="schoolName" class="text_field">
			</p>
			<p>
				<label class="label_input">年龄:&nbsp;&nbsp;</label><input type="text"
					name="teacherAge" class="text_field">
			</p>
			<div id="register_control">
				<input type="submit" id="register" value="注册" />
			</div>
		</form>
	</div>
</body>
</html>