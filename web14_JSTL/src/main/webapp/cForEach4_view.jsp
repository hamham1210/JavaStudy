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
<h2>�츮 ���Կ��� �ǸŵǴ� ���ϵ��Դϴ�.</h2>
<c:forEach items="${list}" var="item">
<!-- items=����Ʈ ã�ƿ��� var=ã�ƿ� ����Ʈ���� ��ü �ϳ����� ã�Ƽ� ���� �� -->
<li>${item}</li>
<!-- �׷��� ��ü�� ��� item�� ����Ʈ�� ����Ѵ�. -->
</c:forEach>

</body>
</html>