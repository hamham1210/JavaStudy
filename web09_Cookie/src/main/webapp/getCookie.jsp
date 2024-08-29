<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>브라우저에 저장된 모든 쿠키 정보를 받아옵니다: request.getCookies()</h2>
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
