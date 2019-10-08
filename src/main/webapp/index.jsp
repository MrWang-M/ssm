<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<table class="table">
    <thead>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品操作</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><span class="glyphicon glyphicon-heart-empty">300</span></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
