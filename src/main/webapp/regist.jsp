<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style>
        .login{
            margin: auto;
            width:600px;
            height:180px;
            position: absolute;
            top: 0px;
            bottom: 0px;
            right: 0px;
            left: 0px;
        }
    </style>
</head>
<body>
<c:if test="${tage == 1}">
    <script>
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg('注册失败');
        });
    </script>
</c:if>
<div class="login">
    <form class="layui-form" action="userRegist.do" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="name" required  lay-verify="required" placeholder="请输用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="pass" required  lay-verify="required" placeholder="请输密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit lay-filter="formDemo">注册</button>
                <button type="button" onclick="javascript:window.location.href='login.jsp';" class="layui-btn layui-btn-primary">登录</button>
            </div>
        </div>
    </form>
</div>

<script>
    layui.use("form",function () {
        var form = layui.form;
    });
</script>
</body>
</html>
