<%@page import="web.http.servlet.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ü ��ȸ</title>
<%
ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
%>
</head>
<body>
    <h2>��ü ��ȸ â</h2>
    <table>
        <thead>
            <tr>
                <th>��ǰ ��ȣ</th>
                <th>��ǰ �̸�</th>
                <th>��ǰ ����</th>
                <th>��ǰ ����</th>
            </tr>
        </thead>
        <tbody>
            <%
            if (list != null && !list.isEmpty()) {
            for (Product p : list) {
            %>
            <tr>
                <td><%=p.getNum()%></td>
                <td><%=p.getName()%></td>
                <td><%=p.getPrice()%></td>
                <td><%=p.getExplain()%></td>
            </tr>
            <%
            }
            }
            %>
        </tbody>
    </table>
    <h3>
        <a href="main.html">INDEX</a>
    </h3>
</body>
</html>
