<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>제품 등록하기</h2>
	<form action="insert.do" method="post">
				<ul>
			<li>상품명:<input type="text" id="name" name="name"></li>
			<li>제조사: <input type="text" id="maker" name="maker"></li>
			<li>가격:  <input type="text" id="price" name="price"> </li>
		</ul>
			<input type="submit" value="DataSend">
	</form>
	
<h2>상품명 (제조사별)검색하기</h2>
	<form action="search.do" method="post">
		<select >
		<option id="name" name="name">이름으로 검색</option>
		<option id="maker" name="maker">상품명으로 검색</option>
		<option >전체검색</option>
		</select>
		<input type="text" id="select">
			<input type="submit" value="DataSend">
	</form>	
</body>
</html>