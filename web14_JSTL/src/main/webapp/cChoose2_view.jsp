<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>c:choose ���� ����ϱ� :: ��������... �Ǵٸ� ������ �ο��Ҷ�...</h2>

	<c:choose>
		<c:when test="${param.NUM=='100' }">
			<B>�ڵ����� 100������ �Ա޵Ǿ����ϴ�.</B>
		</c:when>
		<c:when test="${param.NUM=='200' }">
			<B>�ڵ����� 00������ �Ա޵Ǿ����ϴ�.</B>
		</c:when>

		<c:otherwise>
			<B>�ٽ� Ȯ���ϼ���.</B>
		</c:otherwise>
	</c:choose>
</body>
</html>