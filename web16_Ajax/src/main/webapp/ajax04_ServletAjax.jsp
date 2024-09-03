<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
 $(function(){
$('#AjaxBtn').on('click',()=>{
	let id = $('#userId').val();
	$.ajax({
	type:'post',
	url:'front.do',
	data:{'id':id},
	success:function(result){
		alert(result);
		},
		error:function(xhr,status,message){
			alert("Error Message대기시간 초과 에러"+message);
	},timeout:1000//1초 이상 서버 응답 없을 시 에러처리
	
	})
});//onclick
 
 
 });//load
 </script>
</head>
<body>
	<h2>서블릿으로 비동기 요청하기</h2>
	ID
	<input type="text" name="userId" id="userId" />
	<input type="button" value="AjaxBtn" id="AjaxBtn" />
	<!-- 이 영역에 데이터를 뿌림 -->
	<div id="resultView"></div>
</body>
</html>