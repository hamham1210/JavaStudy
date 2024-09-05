<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${user.name}님이 로그인 되었습니다!!!</h2><br><br>
<a href="book.jsp">도서 등록</a><br><br>
<a href="login.html" onclick="logout()">로그아웃</a><br><br>
<a href="showAllBook.do">도서 리스트</a>

<script type="text/javascript">
function logout() {
	<%-- <%session.invalidate();%> --%>
	alert("로그아웃 하셨습니다.");
}

</script>
</body>
</html>