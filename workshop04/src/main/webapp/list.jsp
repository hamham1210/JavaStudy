<%@page import="web.http.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
ArrayList<Product> list = (ArrayList) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Product List</h2>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>상품가격</th>
					<th>상품설명</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Product p : list) {
				%>
				<tr>
					<td><%=p.getNum()%></td>
					<td><%=p.getName()%></td>
					<td><%=p.getPrice()%></td>
					<td><%=p.getExplain()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<h3><a href="main.html">INDEX</a></h3>
	</div>
</body>
</html>