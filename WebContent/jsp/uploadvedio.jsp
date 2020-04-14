<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/teacherRegister.css" />
<title>教师上传视频</title>
</head>
<body>

	<div id="teacherRegister_frame">
		<h3>上传视频</h3>
		<form name="TUpload" action="TUploadAction" method="post">
		<input type="hidden" name="loginname" value="<%=request.getParameter("loginname") %>"/>
		<input type="hidden" name="userclass" value="<%=request.getParameter("userclass") %>"/>
			<p>
				<label class="label_input">课程编号:&nbsp;&nbsp;</label><input type="text"
					name="courseId" class="text_field">
			</p>
			<p>
				<label class="label_input">课程年级&nbsp;&nbsp;</label>
					<select name="courseGrade" class="text_field">
					<option value="null"  selected="selected"></option>
					<option value="小学" >小学</option>
					<option value="初中">初中</option>
					<option value="高中">高中</option>
					</select>
			</p>
			<p>
				<label class="label_input">课程分类:&nbsp;&nbsp;</label>
					<select name="courseClass" class="text_field">
					<option value="null"  selected="selected"></option>
					<option value="语文">语文</option>
					<option value="数学">数学</option>
					<option value="英语">英语</option>
					<option value="政治">政治</option>
					<option value="地理">地理</option>
					<option value="生物">生物</option>
					<option value="历史">历史</option>
					<option value="物理">物理</option>
					<option value="化学">化学</option>
					</select>
			</p>
			<p>
				<label class="label_input">难度系数:&nbsp;&nbsp;</label>
					<select  class="text_field" name="courseDifficulty">
						<option value="null"  selected="selected"></option>
					<option value="入门">入门</option>
					<option value="初级">初级</option>
					<option value="中级">中级</option>
					<option value="高级">高级</option>
					</select>
			</p>
			<p>
				<label class="label_input">封面地址:&nbsp;&nbsp;</label><input type="text"
					name="courseCoverAddress" class="text_field">
			</p>
			<p>
				<label class="label_input">课程标题:&nbsp;&nbsp;</label><input type="text"
					name="courseTitle" class="text_field">
			</p>
			<p>
				<label class="label_input">视频地址:&nbsp;&nbsp;</label><input type="text"
					name="courseAddress" class="text_field">
			</p>
			<p>
				<label class="label_input">上传作者:&nbsp;&nbsp;</label><input type="text"
					name="courseAuthor" class="text_field">
			</p>
				<p>
				<label>是否通过审核:&nbsp;&nbsp;</label>
					<input name="coursecheck" type="radio" value="否" checked="checked" >否
			</p>
			<div id="register_control">
				<input type="submit" id="upload" value="上传视频" />
			</div>
		
		</form>
	</div>
</body>
</html>