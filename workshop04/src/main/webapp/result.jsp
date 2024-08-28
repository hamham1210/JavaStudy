<%@page import="web.http.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%

Product product1 = (Product)request.getAttribute("product1");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품이 저장되었습니다.</h2>
<p><b>상품 번호</b>   <%=product1.getNum() %></p>
<p><b>상품 명</b>   <%=product1.getName() %></p>
<p><b>상품 가격</b>   <%=product1.getPrice() %></p>
<p><b>상품 설명</b>   <%=product1.getExplain() %></p>

<a href="List">상품목록</a>
</body>
</html>