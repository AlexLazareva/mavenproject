
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" href="../build/styles/index.css" />
    <link rel="stylesheet" href="../build/vendor/bootstrap.css" />
</head>
<body>
<div class="container-fluid container-page">
    <form class="auth form-signin" action="${pageContext.servletContext.contextPath}/auth" method="post">
        <input type="text" id="login" class="auth__field" placeholder="Login" />
        <input type="password" id="password" class="auth__field" placeholder="Password" />
        <button type="submit" class="btn btn-lg btn-primary">Войти</button>
    </form>
</div>
</body>
</html>
