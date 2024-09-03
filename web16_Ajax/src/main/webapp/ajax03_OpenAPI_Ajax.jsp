<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
 		$(function(){
			$('#serverSend').on('click',()=>{

			$.ajax({
			type:'get',
			url:'http://localhost:8888/weather.xml',
			//서버에서 응답하는 데이타 타입을 미리 알려주는 속성
			//요청 시에 데이터 속성을 명시해서 받는다.(특이한 데이터 속성일 때 씀)
			dataType:'xml',
			
			success:function(result){
				//alert(result);
				let str ='';
				$(result).find('list').each(function(index,item){
					let region =$(this).find('region').text();
					let wind =$(this).find('wind').text();
					let rain =$(this).find('rain').text();
					let temp =$(this).find('temp').text();
					
					str +='<tr>';
					str +='<td>'+region+'</td>';
					str +='<td>'+wind+'</td>';
					str +='<td>'+rain+'</td>';
					str +='<td>'+temp+'</td>';
					str +='</tr>';
				});//each
				
				/* $('tbody').html(str); */
				$('tobody>tr*').remove();
				$('tbody').append(str);
			
			}//callback
		
			});//ajax
 			
			});//on
 		});//load
 </script>
</head>
<body>
	<div class="container">
	<div class="jumbotron center-text">
		<h3 align="center">======== OPEN API Weather 데이타 가져오기
			=========</h3>
			</div>
		<p>
			<a href="#" id="serverSend">XML데이타 서버로 요청하기</a>
		</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Region</th>
					<th>wind</th>
					<th>rain</th>
					<th>Temp</th>
				</tr>
			</thead>
		</table>

	</div>
</body>
</html>