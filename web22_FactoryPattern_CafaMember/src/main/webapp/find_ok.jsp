<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>회원 검색 결과</h2>
<h3>${param.id }님에 대한 정보입니다.</h3>
<hr>
이름 ${vo.name}<br><br>
주소 ${vo.address }
</body>
</html>