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
/* label{
	font-size: 25px;
    font-family: ����;
    color: white;
    background-color: #3CD8FF;
    border-radius: 10px;
 
} */
td{
font-size:18px;
  /* border:1px solid #F00 */  
}
p{
	font-size: 30px;
}
input{
border-radius:10px;
}
table{
	font-size: 15px;
/*  border:1px solid #F00    */
	
}

/* table{border-collapse:collapse}
table,td,tr{
	border:1px solid black;
}  */
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body style="background-image:url(http://localhost:8888/BS/images/body2.jpg);  background-attachment:fixed">
<form action="FindCoursesAction" method="post">
<input type="hidden" name="loginname" value="<s:property value="loginname"/>">
<input type="hidden" name="user" value="<s:property value="getuser"/>">
<table width="100%">
<tr>
<td width="60%" rowspan="2"  colspan="2"><h1>Self-learning Net</h1></td>
<td><label>欢迎  <s:property value="XXX"/> 使用</label></td>
<td>
<a href="http://localhost:8888/BS/jsp/login.jsp" onclick="javascript:return confirm('注销之后需要登录才能使用！');">注销</a>
</td></tr>
<tr>
<td><input name="context" type="text"><input name="finding" type="submit"   value="serach">
</td>
<td>
<a  href="http://localhost:8888/BS/PersonalAction?username=<s:property value="getuser"/>&loginname=<s:property value="loginname"/>"> 个人中心</a> 
</td>
</tr>


<tr height="40">
<td colspan="3"></td>
<td>
<s:if test="%{getuser.equals('student')}">
 <s:property value="information"/><s:property value="scores"/>
 </s:if>
 </td>
</tr>
</table>
</form>

<form action="SearchCoursesAction" method="post">
<input type="hidden" name="loginname" value="<s:property value="loginname"/>">
<input type="hidden" name="user" value="<s:property value="getuser"/>">
<table width="100%">
<tr height="50">
<td>年级</td>
<td><input  name="grade" type="radio"  value="all" checked="checked" >全部</td>
<td><input  name="grade" type="radio"   value="小学" >小学</td>
<td><input name="grade" type="radio"  value="初中" >初中</td>
<td><input  name="grade" type="radio"   value="高中" >高中</td>
<td  colspan="6"></td>
</tr >
<tr height="50">
<td>分类</td>
<td><input name="class"  type="radio" value="all" checked="checked">全部</td>
<td><input name="class"  type="radio" value="语文"  >语文</td>
<td><input name="class"  type="radio" value="英语" >英语</td>
<td><input name="class" type="radio" value="数学" >数学</td>
<td><input name="class" type="radio" value="政治" >政治</td>
<td><input name="class" type="radio" value="历史" >历史</td>
<td><input name="class" type="radio" value="地理" >地理</td>
<td><input name="class" type="radio" value="生物" >生物</td>
<td><input name="class" type="radio" value="物理" >物理</td>
<td><input name="class" type="radio" value="化学" >化学</td>
</tr>
<tr height="50">
<td>难度系数</td>
<td><input name="difficulty" type="radio" value="all"  checked="checked">全部</td>
<td><input name="difficulty" type="radio" value="入门" >入门</td>
<td><input name="difficulty" type="radio" value="初级" >初级</td>
<td><input name="difficulty" type="radio" value="中级" >中级</td>
<td><input name="difficulty" type="radio" value="高级" >高级</td>
<td  colspan="5"></td>
</tr>
<tr>
<td  colspan="9"></td>
<td  colspan="2"><input width="40" name="search" type="submit" value="search" ></td>
</tr>
</table>
</form>

<p>推荐课程>>></p>
<table  width="100%">
<tr>
<td><label>经典语文</label></td>
<td>
<label><a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="chinese[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td><!-- action,传递科目 -->
</tr>
<tr>
<td colspan="2">
<s:iterator value="chinese"  var="chinese">

<table class="kuang" style="float:left" width="23%">
<tr>
<td>
<%-- <embed width="200" height="200" src="<s:property value="#chinese.courseAddress"/>" autoplay="false"> --%>
<a href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#chinese.courseAddress"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><!--action进行显示  -->
<img  width="100%" height="180"  src="<s:property value="#chinese.courseCoverAddress"/>"></a>
</td>
</tr>
<tr>
<td>课题：<s:property value="#chinese.courseTitle"/></td>
</tr>
<tr>
<td >作者：<s:property value="#chinese.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#chinese.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#chinese.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#chinese.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
</td>
</tr>
<tr><td colspan="2"><p>........................................................................................................................................................</p></td></tr>

<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr><!--3  -->
<td><label>经典数学</label></td>
<td  align="left">
<label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="math[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr><!-- 4 -->
<td colspan="2">
<s:iterator value="math"  var="math">
<table class="kuang" style="float:left" width="23%">
<tr>
<td>
<%-- <embed width="200" height="200" src="<s:property value="#math.courseAddress"/>" autoplay="false">--%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#math.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#math.courseCoverAddress"/>"></a>
</td> 
</tr>
<tr>
<td>课题：<s:property value="#math.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#math.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#math.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#math.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#math.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
<br/><br/><br/><br/>
</td>
</tr>
<tr><td colspan="2"><p>......................................................................................................................................................</p></td></tr>
<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr>
<td><label>经典英语</label></td>
<td  align="left">
<label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="english[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr>
<td colspan="2">
<s:iterator value="english"  var="english">
<table class="kuang" style="float:left" width="23%">
<tr>
<td>
<%-- <embed width="200" height="200"  src="<s:property value="#english.courseAddress"/>" autoplay="false"> --%>
<a href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#english.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#english.courseCoverAddress"/>"></a>
</td>
</tr>
<tr>
<td>课题：<s:property value="#english.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#english.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#english.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#english.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#english.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
</td>
</tr>
<tr><td colspan="2"><p>.......................................................................................................................................................</p></td></tr>
<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr><!--3  -->
<td><label>经典政治</label></td>
<td  align="left"><label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="political[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr><!-- 4 -->
<td colspan="2">
<s:iterator value="political"  var="political">
<table class="kuang" style="float:left" width="23%">
<tr>
<td >
<%-- <embed width="200" height="200" src="<s:property value="#math.courseAddress"/>" autoplay="false">--%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#political.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#political.courseCoverAddress"/>"></a>
</td> 
</tr>
<tr>
<td>课题：<s:property value="#political.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#political.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#political.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#political.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#political.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
<br/><br/><br/><br/>
</td>
</tr>
<tr><td colspan="2"><p>......................................................................................................................................................</p></td></tr>
<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr><!--3  -->
<td><label>经典历史</label></td>
<td  align="left"><label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="history[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr><!-- 4 -->
<td colspan="2" >
<s:iterator value="history"  var="history">
<table class="kuang" style="float:left" width="23%">
<tr>
<td>
<%-- <embed width="200" height="200" src="<s:property value="#math.courseAddress"/>" autoplay="false">--%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#history.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#history.courseCoverAddress"/>"></a>
</td> 
</tr>
<tr>
<td>课题：<s:property value="#history.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#history.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#history.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#history.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#history.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
<br/><br/><br/><br/>
</td>
</tr>
<tr><td colspan="2"><p>......................................................................................................................................................</p></td></tr>
<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr><!--3  -->
<td><label>经典地理</label></td>
<td  align="left"><label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="geography[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr><!-- 4 -->
<td>
<s:iterator value="geography"  var="geography">
<table class="kuang" style="float:left" width="23%">
<tr>
<td colspan="2">
<%-- <embed width="200" height="200" src="<s:property value="#math.courseAddress"/>" autoplay="false">--%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#geography.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#geography.courseCoverAddress"/>"></a>
</td> 
</tr>
<tr>
<td>课题：<s:property value="#geography.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#geography.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#geography.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#geography.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#geography.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
<br/><br/><br/><br/>
</td>
</tr>
<tr><td colspan="2"><p>......................................................................................................................................................</p></td></tr>
<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr><!--3  -->
<td><label>经典生物</label></td>
<td  align="left"><label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="biology[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr><!-- 4 -->
<td colspan="2">
<s:iterator value="biology"  var="biology">
<table class="kuang" style="float:left" width="23%">
<tr>
<td >
<%-- <embed width="200" height="200" src="<s:property value="#math.courseAddress"/>" autoplay="false">--%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#biology.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#biology.courseCoverAddress"/>"></a>
</td> 
</tr>
<tr>
<td>课题：<s:property value="#biology.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#biology.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#biology.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#biology.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#biology.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
<br/><br/><br/><br/>
</td>
</tr>
<tr><td colspan="2"><p>......................................................................................................................................................</p></td></tr>

<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr><!--3  -->
<td><label>经典化学</label></td>
<td  align="left"><label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="chemistry[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr><!-- 4 -->
<td colspan="2">
<s:iterator value="chemistry"  var="chemistry">
<table class="kuang" style="float:left" width="23%">
<tr>
<td>
<%-- <embed width="200" height="200" src="<s:property value="#math.courseAddress"/>" autoplay="false">--%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#chemistry.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#chemistry.courseCoverAddress"/>"></a>
</td> 
</tr>
<tr>
<td>课题：<s:property value="#chemistry.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#chemistry.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#chemistry.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#chemistry.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#chemistry.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
<br/><br/><br/><br/>
</td>
</tr>
<tr><td colspan="2"><p>.....................................................................................................................................................</p></td></tr>
<tr height="30">
<td><label>    </label></td>
<td><label>    </label></td>
</tr>
<tr><!--3  -->
<td><label>经典物理</label></td>
<td  align="left"><label>
<a href="http://localhost:8888/BS/MoreCoursesAction?courseId=<s:property value="physical[0].courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>"><input type="button" value="更多"></a>
</label></td>
</tr>

<tr><!-- 4 -->
<td colspan="2">
<s:iterator value="physical"  var="physical">
<table class="kuang" style="float:left" width="23%">
<tr>
<td>
<%-- <embed width="200" height="200" src="<s:property value="#math.courseAddress"/>" autoplay="false">--%>
<a  href="http://localhost:8888/BS/ShowVideoAction?courseAddress=<s:property value="#physical.courseAddress"/>">
<img alt="" width="100%" height="180" src="<s:property value="#physical.courseCoverAddress"/>"></a>
</td> 
</tr>
<tr>
<td>课题：<s:property value="#physical.courseTitle"/></td>
</tr>
<tr>
<td>作者：<s:property value="#physical.courseAuthor"/></td>
</tr>
<tr>
<td>年级：<s:property value="#physical.courseGrade"/></td>
</tr>
<tr>
<td>难度系数：<s:property value="#physical.courseDifficulty"/></td>
</tr>
<tr>
<td><a href="http://localhost:8888/BS/SubscibeCourseAction?courseId=<s:property value="#physical.courseId"/>&loginname=<s:property value="loginname"/>&userclass=<s:property value="getuser"/>">
<s:property value="hint"/></a></td>
</tr>
</table>
</s:iterator>
<br/><br/><br/><br/>
</td>
</tr>


</table>
<s:debug></s:debug>
</body>
</html>

