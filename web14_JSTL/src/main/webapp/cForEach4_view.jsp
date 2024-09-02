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
<h2>우리 가게에서 판매되는 과일들입니다.</h2>
<c:forEach items="${list}" var="item">
<!-- items=리스트 찾아오기 var=찾아온 리스트에서 객체 하나씩을 찾아서 넣을 곳 -->
<li>${item}</li>
<!-- 그래서 객체가 담긴 item을 리스트로 출력한다. -->
</c:forEach>

</body>
</html>