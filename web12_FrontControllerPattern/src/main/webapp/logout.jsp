<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Logout!~");

	}
</script>
</head>
<body>
	<%
	Member vo = (Member) session.getAttribute("vo");
	if (vo == null) {//�α��� �ȵ� ���¶��.. �α��� �������� �̵�
	%>

	<h3>
		<a href="Login.jsp"> �α��� �ϱ�</a>
	</h3>
	<%
	} else {//�α��� �� ����...�α׾ƿ��� ����(������ death)
	session.invalidate();
	%>
	<b>�α׾ƿ� �Ǽ̽��ϴ�.</b>
	<br>
	<a href="index.html">Index�������� ����</a>
	<% 
	}
	%>
</body>
</html>