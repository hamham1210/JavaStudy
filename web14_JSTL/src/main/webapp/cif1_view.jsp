<!-- 만약에 폼값에 입력된 숫자가 100이면 
자동차세 100만원 입금되었습니다...
만약에 폼값에 입력된 숫자가 200이면
보증금 200만원 입금되었습니다... 

JSTL IF문으로 작성...
1) jar파일 2개 (jstl.jar, standard.jar) 드라이버에 설치 완료
2) taglib(taglibary라고 읽음) 선언문 필요

-->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--taglib 선언문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL의 if문을 다뤄보자...</h2>
	<c:if test="${param.NUM=='100'}">
		<b>자동차세 100만원이 입금되었습니다.</b>
		<br>

	</c:if>

	<c:if test="${param.NUM=='200'}">
		<b>재산세 200만원이 입금되었습니다.</b>
		<br>

	</c:if>
	
</body>
</html>