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
<c:choose>
<c:when test="${empty vo}">
	<h4>�α��κ��� �ٽ� ���ּ���</h4>
	<a href="index.jsp">����� �ٽ� ������.</a>
</c:when>
<c:otherwise>
	<h2>Login result</h2>
	ID${vo.id}<br>
	<br> Name${vo.name}<br>
	<br> Address${vo.address}<br>
	<br>
	<hr>
	<a href="logout.do">Logout</a>
	<a href="index.jsp">Index</a>
	</c:otherwise>
	</c:choose>
</body>
</html>