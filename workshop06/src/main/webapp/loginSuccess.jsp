<%@page import="servlet.model.User"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
 User user = (User)session.getAttribute("user");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><%=user.getName() %>���� �α��� �Ǿ����ϴ�!!!</h2><br><br>
<a href="Book.html">���� ���</a><br><br>
<a href="login.html" onclick="logout()">�α׾ƿ�</a><br><br>
<script type="text/javascript">
function logout() {
	<%session.invalidate();%>
	alert("�α׾ƿ� �ϼ̽��ϴ�.");
}

</script>
</body>
</html>