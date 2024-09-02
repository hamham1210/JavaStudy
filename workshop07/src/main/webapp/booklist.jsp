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
<h2>도서 목록 화면</h2>
<form action="front.do?command=showAllBook">
<select name="bookCategory" id="lang">
	<option value="all">전체</option>
    <option value="title">도서명</option>
    <option value="golang">출판사</option>
    <option value="python">가격</option>
</select>
<input type="hidden" name="search" value="allbookshow">
<input type="text" name="condDesc">
<input type="submit" value="제출">
</form>
<table class="table table-striped">
<thead>
        <tr>
            <th>도서 번호</th>
            <th>도서명</th>
            <th>도서분류</th>
            <th>저자</th>
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

<a href="book.jsp">도서 등록</a>
</body>
</html>