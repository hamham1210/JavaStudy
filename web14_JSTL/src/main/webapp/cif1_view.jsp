<!-- ���࿡ ������ �Էµ� ���ڰ� 100�̸� 
�ڵ����� 100���� �ԱݵǾ����ϴ�...
���࿡ ������ �Էµ� ���ڰ� 200�̸�
������ 200���� �ԱݵǾ����ϴ�... 

JSTL IF������ �ۼ�...
1) jar���� 2�� (jstl.jar, standard.jar) ����̹��� ��ġ �Ϸ�
2) taglib(taglibary��� ����) ���� �ʿ�

-->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--taglib ���� -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL�� if���� �ٷﺸ��...</h2>
	<c:if test="${param.NUM=='100'}">
		<b>�ڵ����� 100������ �ԱݵǾ����ϴ�.</b>
		<br>

	</c:if>

	<c:if test="${param.NUM=='200'}">
		<b>��꼼 200������ �ԱݵǾ����ϴ�.</b>
		<br>

	</c:if>
	
</body>
</html>