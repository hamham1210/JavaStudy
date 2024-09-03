<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>register</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#idCheck').on('click',()=>{
			let id = $('#id').val();
			$.ajax({
				type:'post',
				url:'front.do?command=idCheck',
				data:{'id':id},
				//result값 받아서.. true/false출력
				//resultView받아서.. true
				success:function(result){
					if(result=='true'){
					alert(id);
					$('#resultView').html('<h3><font color=red>사용중인 ID!</font></h3>')	
					}else{
						$('#resultView').html('<h3><font color=blue>가능한 ID!</font></h3>')	
					}
					},
					error:function(xhr,status,message){
						alert("에러났습니다.");
				}	
			})//ajax
		})//on
	
	});//load
	</script>
</head>
<body>
<h2>회원 가입</h2>
<form action="front.do" method="post">
<input type="hidden" name="command" value="register">
ID <input type="text" name="id" id="id" required="required">
<input type="button" value="중복확인" id="idCheck">
<span id="resultView"></span>
<br><br>
PASS <input type="text" name="pass" required="required"><br><br>
Name <input type="text" name="name" ><br><br>
Address<input type="text" name="address" ><br><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>