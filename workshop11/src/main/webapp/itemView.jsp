<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
/*  * {
	border: 2px solid black;
}  */
#header{
background: orange;
display: flex;
justify-content: flex-end;
}
.header_item{
 margin :10px;
 
}
img{
width: 700px;
	height: 500px;
}
#main{
display: flex;
justify-content: center;
padding:3%;
}
#desc{
margin-bottom: 50px;
}
.desc{
margin-top:30%
}
a{
display: block;
text-align: center;
}
</style>
</head>
<body>
	<h3 style="text-align: center;">${item.name}�� ����</h3>
	
	<div id="header">
		<p class="header_item">��ȸ�� : ${item.count}</p>
		<p class="header_item">��ٱ��� ���</p>
		<p class="header_item">��ٱ��� Ȯ��</p>
	</div>
	<div id="main">
		<img alt="" src="${item.url}">
		<div id="desc-body">
			<p id="desc">����: ${item.name}</p>
			<p id="desc">����: ${item.price}</p>

			<p class="desc">����: ${item.description}</p>
		</div>
	</div>
	<a href="itemList.do" >��ǰ ��� ����</a>
	
</body>
</html>