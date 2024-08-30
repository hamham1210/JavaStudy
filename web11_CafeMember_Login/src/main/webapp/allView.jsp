<%@page import="java.util.ArrayList"%>
<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%>
</head>
<body>
<h3 align="center">회원 전체 명단 보기</h3>
<table border="2" width="400px" bgcolor="Dodger Blue" align="center">
<%

for(Member p: list){

%>
<tr>
<td><%=p.getId() %></td>
<td><%=p.getName() %></td>
<td><%=p.getAddress() %></td>
</tr>
<%

}

%>
</table>

<p></p>
<h3 align="center"><a href="index.html">INDEX</a></h3>
</body>
</html>
