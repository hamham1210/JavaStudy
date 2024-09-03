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
				//result�� �޾Ƽ�.. true/false���
				//resultView�޾Ƽ�.. true
				success:function(result){
					if(result=='true'){
					alert(id);
					$('#resultView').html('<h3><font color=red>������� ID!</font></h3>')	
					}else{
						$('#resultView').html('<h3><font color=blue>������ ID!</font></h3>')	
					}
					},
					error:function(xhr,status,message){
						alert("���������ϴ�.");
				}	
			})//ajax
		})//on
	
	});//load
	</script>
</head>
<body>
<h2>ȸ�� ����</h2>
<form action="front.do" method="post">
<input type="hidden" name="command" value="register">
ID <input type="text" name="id" id="id" required="required">
<input type="button" value="�ߺ�Ȯ��" id="idCheck">
<span id="resultView"></span>
<br><br>
PASS <input type="text" name="pass" required="required"><br><br>
Name <input type="text" name="name" ><br><br>
Address<input type="text" name="address" ><br><br>
<input type="submit" value="ȸ������">
</form>
</body>
</html>