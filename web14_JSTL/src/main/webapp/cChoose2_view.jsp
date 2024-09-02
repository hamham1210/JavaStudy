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
	<h2>c:choose 문법 사용하기 :: 양자택일... 또다른 조건을 부여할때...</h2>

	<c:choose>
		<c:when test="${param.NUM=='100' }">
			<B>자동차세 100만원이 입급되었습니다.</B>
		</c:when>
		<c:when test="${param.NUM=='200' }">
			<B>자동차세 00만원이 입급되었습니다.</B>
		</c:when>

		<c:otherwise>
			<B>다시 확인하세요.</B>
		</c:otherwise>
	</c:choose>
</body>
</html>