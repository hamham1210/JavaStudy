<%@page import="web.servlet.controller.workshop03.User"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
 User user = (User)request.getAttribute("user");
 
String name = user.getName();

 
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><%=user.getName() %>님이 로그인 되었습니다!!!</h2><br><br>
<a href="">도서 등록</a><br><br>
<a href="">로그아웃</a><br><br>
</body>
</html>