<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
<h2>���� ��� ȭ��</h2>
<form action="front.do?command=showAllBook">
<select name="bookCategory" id="lang">
	<option value="all">��ü</option>
    <option value="title">������</option>
    <option value="golang">���ǻ�</option>
    <option value="python">����</option>
</select>
<input type="hidden" name="search" value="allbookshow">
<input type="text" name="condDesc">
<input type="submit" value="����">
</form>
<table class="table table-striped">
<thead>
        <tr>
            <th>���� ��ȣ</th>
            <th>������</th>
            <th>�����з�</th>
            <th>����</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
    <tr>
    <td>${item.isbn}</td>
    <td>${item.title}</td>
    <td>${item.catalogue}</td>
    <td>${item.author}</td>
     </tr>
     </c:forEach>
    </tbody>
</table>

<a href="book.jsp">���� ���</a>
</body>
</html>