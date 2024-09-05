<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2,h4{
text-align: center;
}
a{margin:15px;}
</style>
</head>
<body>
<h2>INDEX PAGE</h2>

<p/>
<h4>${msg}</h4>
<c:if test="${empty user}">
<c:import url="login.html"></c:import>
<h4><a href="addMember.do">회원 가입</a></h4>
<h4><a href="showAllBook.do">도서 목록</a></h4>
</c:if>
<c:if test="${not empty user}">
<h4><a href="book.jsp">도서 등록</a></h4>
<h4><a href="showAllBook.do">도서 목록</a></h4>
</c:if>





</body>
</html>