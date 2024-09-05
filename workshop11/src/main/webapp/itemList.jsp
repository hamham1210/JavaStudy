<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
/* * {
	border: 2px solid black;
} */
img {
	width: 200px;
	height: 200px;
	border: 2px solid #4B89DC;
	border-radius: 10%
}

#displaybox {
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
	align-items: center;
	padding: 0 10%
}

p {
	display: flex;
	justify-content: center;
	flex-direction: row;
}
</style>
<script>
$(function() {
		$('img').hover(function() {
			$(this).css('border', '2px solid red');
		}, function() {
			$(this).css('border', '2px solid #4B89DC');
		});
	});
</script>
</head>
<body>
	<h2 style="text-align: center; color: #4B89DC;">Fruit Total List
		1.</h2>
	<div id="displaybox">
		<c:forEach items="${list}" var="item">
			<div class="flex-container">
				 <a href="itemView.do?id=${item.itemNumber}">
				 <img src="${item.url}" alt="${item.name}"></a>
				<p>상품명 : ${item.name}</p>
				<p>가격 : ${item.price} 원</p>
			</div>
		</c:forEach>
	</div>
</body>
