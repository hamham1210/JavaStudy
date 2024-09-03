<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
$('#title').on('mouseover',()=>{
		let title =$('#title').val();
		$.ajax({
				type:'get',
				url:'front.do?command=searchDetail'
				data:{'title':title},
				success:function(result){
					$('#bookDetailPage').html(result);
				}
				error:function(xhr,status,message){
					alert("에러났습니다.");
			}	
		
		
				})//ajax
				})//on
				})//load
</script>
</head>
<body>
	<h2>도서 목록 화면</h2>
	<form action="front.do">
	<input type="hidden" name="command" value="searchBook">
		<select name="bookCategory">
			<option value="all">전체</option>
			<option value="title">도서명</option>
            <option value="catalogue">도서분류</option>
            <option value="author">저자</option>
		</select> 
		<input type="text" name="condDesc">
		 <input type="submit" value="제출">
	</form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>도서 번호</th>
				<th>도서명</th>
				<th>도서분류</th>
				<th>저자</th>
			</tr>
		</thead>
		<tbody>
	
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.isbn}</td>
					<td><a id="title" href="#">${item.title}</a></td>
					<td>${item.catalogue}</td>
					<td>${item.author}</td>
				</tr>
			</c:forEach>

			
		</tbody>
	</table>
<span id="bookDetailPage"></span>
	<a href="book.jsp">도서 등록</a>
</body>
</html>