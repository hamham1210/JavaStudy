<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>결과페이지</h2>
<b>당신이 선택한 도시는 
<%= request.getParameter("city")

%>입니다.</b>
</body>
</html>