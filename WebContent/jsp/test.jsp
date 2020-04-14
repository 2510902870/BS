<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var name = prompt("评论留言：");
document.write(name);
</script>
</head>
<body>

<input type="text" value="提示文字" 
onFocus="if(value==defaultValue){value=''; this.style.color='#000'}" 
onBlur="if(!value){value==defaultValue; this.style.color='#999';}" />

<!-- <img alt="" src="/imgUrl/title.png"> -->
 <!-- <embed height="300" hidden="true" src="/imgUrl/110.mp4" autoplay="false"> -->
<button onclick="zhouxiaoze()">click</button>
</body>
</html>