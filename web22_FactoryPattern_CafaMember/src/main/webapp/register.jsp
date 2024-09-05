<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>register</title>
</head>
<body>
<h2>회원 가입</h2>
<form action="register.do" method="post">
ID <input type="text" name="id" required="required"><br><br>
PASS <input type="text" name="pass" required="required"><br><br>
Name <input type="text" name="name" ><br><br>
Address<input type="text" name="address" ><br><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>