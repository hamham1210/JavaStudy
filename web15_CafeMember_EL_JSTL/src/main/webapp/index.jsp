<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>index</title>
<style>
a:HOVER{
color: red
}
</style>
</head>
<body>
<div class="container">
  <div class="jumbotron text-center" >
    <h2>DB �������� Cafe Member Manage...Using EL,JSTL... FrontController</h2>
    
    <p></p>  
    <p><a href="find.jsp">ȸ�� �˻�</a></p>    
    <c:choose>
    <c:when test="${!empty vo}">
    <p><a href="front.do?command=showAll">��ü ȸ�� �˻�</a></p>
    <p><a href="update.jsp">ȸ�� ���� �����ϱ�</a></p>
    <p><a href="front.do?command=logout">�α׾ƿ� �ϱ�</a></p>
    </c:when>
    <c:otherwise>
    <p><a href="register.jsp">ȸ�� ����</a></p>
    <p><a href="login.jsp">�α��� �ϱ�</a></p>
    </c:otherwise>
     </c:choose>
  </div>
  </div>
</body>
</html>