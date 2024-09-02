<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--taglib 선언문 -->
</head>
<body>
<h2>c:forEach문 사용하기</h2>
<c:forEach var ="cnt" begin="1" end="7">
<font size="${cnt}" > hello Nice Day~~!!<br>

</c:forEach>
</body>
</html>