<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<%
	Member vo = (Member) session.getAttribute("vo");
	String product = (String) session.getAttribute("pname");
	if (vo == null) {//로그인 상태가 아니라면
	%>
	<h3>로그인 부터 하세요...</h3>
	<a href="login.html">로그인 하러가기</a>
	<%
	}
	%>
	<h2>Result Page...</h2>
	ID
	<b><%=vo.getId()%></b> Name
	<b><%=vo.getName()%></b> Address
	<b><%=vo.getAddress()%></b> ProductName
	<b><%=product%></b>
</body>
</html>