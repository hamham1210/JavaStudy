<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script type="text/javascript">


 $(function(){
	$('#test').css('color','red');
	$('#ajax').on('click', ()=> {
		alert('�׽�Ʈ��');
		//�񵿱� ��� ����..
		$.ajax({
		//��û�κ�
		type:'get',
		url:'http://localhost:8888/web16_Ajax/bank.json',
		//����κ�
		success:function(resultData){
 			alert(resultData);
								},
		error:function(e){
			alert(e+"... ����ð��� �ʹ� �����˴ϴ�... �ٽ� �õ����ּ���.")
								}
						//callback
		//timeout:1000//1�� ���� �����κ��� ������ ������ Error�߻�(����ð� ���� ����)
		});//ajax
	});//on
 });//ready
 </script>

</head>
<body>
	<h3 id="test">��ư Ŭ�� �� �񵿱� ��� ����</h3>
	<input type="button" value="JQuery Ajax" id="ajax">
</body>
</html>