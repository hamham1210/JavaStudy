<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL</title>
</head>
<body>
<h2>Attribute�� ���ε��� ���� EL�� �޾ƿ���</h2>
<h3>�ش� JSP������ �������� �������ּ���...</h3>
<%
int sum = 0;
for(int cnt=0; cnt<=50; cnt++) sum += cnt;//5050

//���ε�
request.setAttribute("RESULT1", sum);
session.setAttribute("RESULT2", "SESSION");

//�׺���̼�
request.getRequestDispatcher("el1_view.jsp").forward(request, response);
%>

</body>
</html>