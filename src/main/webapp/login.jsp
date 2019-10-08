<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        .login{
            width: 600px;
            margin: auto;
        }
    </style>
</head>
<body>
<div class="login">
    <form method="post" action="user/userLogin.do">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" name="user" class="form-control" id="username">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" name="pass" class="form-control" id="password">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>
