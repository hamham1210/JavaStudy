<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP기본 Element 사용하기</b><br>
<%=request.getParameter("myId") %><br>

<b>2. JSP EL사용하기</b><br>
${param.myId}
<hr>
<b>3. JSP Menu에 해당하는 값 Element로 받아오기</b><br>
<% String[] menus =request.getParameterValues("menu"); 
for(String menu : menus){
    %>
<b><%=menu %></b>
<%
}
%>
<b>4.JSP Menu에 해당하는 값 EL로 받아오기</b><br>
선택한 메뉴 ::
${paramValues.menu[0] }
${paramValues.menu[1] }
${paramValues.menu[2] }
${paramValues.menu[3] }
</body>
</html>