
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
        <input type="text" id="login" name="login" class="auth__field" placeholder="Логин" />
        <input type="password" id="password" name="psswd" class="auth__field" placeholder="Пароль" />
        <button type="submit" class="btn btn-lg btn-primary">Войти</button>
    </form>
</div>
</body>
</html>
