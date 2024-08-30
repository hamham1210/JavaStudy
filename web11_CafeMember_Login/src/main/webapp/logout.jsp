<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Logout!~");

	}
</script>
</head>
<body>
	<%
	Member vo = (Member) session.getAttribute("vo");
	if (vo == null) {//로그인 안된 상태라면.. 로그인 페이지로 이동
	%>

	<h3>
		<a href="Login.jsp"> 로그인 하기</a>
	</h3>
	<%
	} else {//로그인 된 상태...로그아웃을 진행(세션을 death)
	session.invalidate();
	%>
	<b>로그아웃 되셨습니다.</b>
	<br>
	<a href="index.html">Index페이지로 가기</a>
	<% 
	}
	%>
</body>
</html>