<%@page import="java.io.PrintWriter"%>
<%@page import="servlet.model.User"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String sessionId = session.getId();
out.println("<p>Session ID: " + sessionId + "</p>");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>${session.name}���� �α��� �Ǿ����ϴ�!!!</h2><br><br>
<a href="book.jsp">���� ���</a><br><br>
<a href="login.html" onclick="logout()">�α׾ƿ�</a><br><br>
<script type="text/javascript">
function logout() {
	<%-- <%session.invalidate();%> --%>
	alert("�α׾ƿ� �ϼ̽��ϴ�.");
}

</script>
</body>
</html>