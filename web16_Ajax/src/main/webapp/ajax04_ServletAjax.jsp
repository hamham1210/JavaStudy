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
			alert("Error Message���ð� �ʰ� ����"+message);
	},timeout:1000//1�� �̻� ���� ���� ���� �� ����ó��
	
	})
});//onclick
 
 
 });//load
 </script>
</head>
<body>
	<h2>�������� �񵿱� ��û�ϱ�</h2>
	ID
	<input type="text" name="userId" id="userId" />
	<input type="button" value="AjaxBtn" id="AjaxBtn" />
	<!-- �� ������ �����͸� �Ѹ� -->
	<div id="resultView"></div>
</body>
</html>