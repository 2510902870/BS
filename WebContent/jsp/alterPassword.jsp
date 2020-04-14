<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <link rel="stylesheet" type="text/css" href="../css/alterPassword.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<div id="login_frame">
    <p><img src="../images/admin.jpg" width=50 height=50></p>
    <form method="post"  action="AlterPasswordAction">
         <p><label class="label_input">用户名</label><input type="text"  name="username" class="text_field"/></p>
        <p><label class="label_input">旧密码</label><input type="text"  name="oldpassword" class="text_field"/></p>
        <p><label class="label_input">新密码</label><input type="password" name="password" class="text_field"/></p>
 	    <p><label class="label_input">确定密码</label><input type="password" name="repassword" class="text_field"/></p>
 	    <p><input name="user"  type="radio" value="student" checked="checked"><label>学生</label>
     		<input name="user" type="radio" value="teacher"><label>教师</label>
     		</p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="确认修改" />
        </div>
    </form>
</div>
</body>
</html>