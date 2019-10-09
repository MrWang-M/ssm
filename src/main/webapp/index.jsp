<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>

    <script>
        function item_click(id) {
            var item = $("#" + id);
            var status = item.attr("status");
            if (status == 0) {
                item.html(parseInt(item.html()) + 1);
                item.removeClass("layui-icon-rate");
                item.addClass("layui-icon-rate-solid")
                item.attr("status", 1);
                $.post("addZan.do", {"itemId": id});
            } else {
                item.html(parseInt(item.html()) - 1);
                item.removeClass("layui-icon-rate-solid");
                item.addClass("layui-icon-rate")
                item.attr("status", 0);
                $.post("renameZan.do", {"itemId": id});
            }
        }
    </script>
</head>
<body>
<table class="table">
    <div class="layui-form">
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
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
                    <td><span onclick="item_click('${item.id}')" id="${item.id}" class="layui-icon layui-icon-rate"
                              status="0">${item.zan}</span></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

</table>
</body>
</html>
