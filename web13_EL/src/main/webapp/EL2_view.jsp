<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP�⺻ Element ����ϱ�</b><br>
<%=request.getParameter("myId") %><br>

<b>2. JSP EL����ϱ�</b><br>
${param.myId}
<hr>
<b>3. JSP Menu�� �ش��ϴ� �� Element�� �޾ƿ���</b><br>
<% String[] menus =request.getParameterValues("menu"); 
for(String menu : menus){
    %>
<b><%=menu %></b>
<%
}
%>
<b>4.JSP Menu�� �ش��ϴ� �� EL�� �޾ƿ���</b><br>
������ �޴� ::
${paramValues.menu[0] }
${paramValues.menu[1] }
${paramValues.menu[2] }
${paramValues.menu[3] }
</body>
</html>