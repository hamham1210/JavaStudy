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

	if (vo == null) {
	%>
	<h4>�α��κ��� �ٽ� ���ּ���</h4>
	<a href="index.html">����� �ٽ� ������.</a>
	<%
	}
	%>
	<h2>Login result</h2>
	ID<%=vo.getId()%><br>
	<br> Name<%=vo.getName()%><br>
	<br> Address<%=vo.getAddress()%><br>
	<br>
	<hr>
	<a href="logout.jsp">Logout</a>
	<a href="index.html">Index</a>
</body>
</html>