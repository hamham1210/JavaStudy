<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1.  JSP기본 Element로 받아오기:</b><br>
<%= request.getAttribute("RESULT1") %><br>
<%= request.getAttribute("RESULT2") %>
<hr>
<b>2.  JSP기본 EL로 받아오기:</b><br>
1)${RESULT1}<br>
2)${RESULT2}<br>
3)${RESULT1}+50<br>
</body>
</html>