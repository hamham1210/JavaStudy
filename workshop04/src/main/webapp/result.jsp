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
<h2>��ǰ�� ����Ǿ����ϴ�.</h2>
<p><b>��ǰ ��ȣ</b>   <%=product1.getNum() %></p>
<p><b>��ǰ ��</b>   <%=product1.getName() %></p>
<p><b>��ǰ ����</b>   <%=product1.getPrice() %></p>
<p><b>��ǰ ����</b>   <%=product1.getExplain() %></p>

<a href="List">��ǰ���</a>
</body>
</html>