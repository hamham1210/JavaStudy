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
<h2><%=user.getName() %>���� �α��� �Ǿ����ϴ�!!!</h2><br><br>
<a href="">���� ���</a><br><br>
<a href="">�α׾ƿ�</a><br><br>
</body>
</html>