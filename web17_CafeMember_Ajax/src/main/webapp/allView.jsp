<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<h3 align="center">회원 전체 명단 보기</h3>
	<table border="2" width="400px" bgcolor="Dodger Blue" align="center">
		<c:forEach items="${list}" var="vo">
		
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.address}</td>
		</tr>
		</c:forEach>
	</table>

	<p></p>
	<h3 align="center">
		<a href="index.html">INDEX</a>
	</h3>
</body>
</html>
