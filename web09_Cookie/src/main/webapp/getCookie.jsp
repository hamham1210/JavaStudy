<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�������� ����� ��� ��Ű ������ �޾ƿɴϴ�: request.getCookies()</h2>
<% 
    Cookie[] newjeans = request.getCookies(); 

    if (newjeans != null) {
%>
<ul>
<% 
        for(Cookie cs : newjeans){
%>
<li>Cookie Name : <%= cs.getName() %></li>
<li>Cookie Value : <%= cs.getValue() %></li>
<% 
        } 
    }
%>
</ul>
</body>
</html>
