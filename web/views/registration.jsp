<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация нового пользователя</title>
    <link rel="stylesheet" href="./../build/styles/index.css" />
    <link rel="stylesheet" href="./../build/vendor/bootstrap.css" />
</head>
<body>
<div class="container-fluid container-page">
    <form class="auth form-signin" id="clientRegistrationForm" action="${pageContext.servletContext.contextPath}/regClient" method="post">
        <h1>Регистрация</h1>
        <!-- Логин пользователя -->
        <div class="form-group">
            <label for="login">Логин</label>
            <input type="text" class="form-control" id="login" aria-describedby="userHelp" />
            <small id="userHelp" class="form-text text-muted">Придумайте логин для авторизации в системе.</small>
        </div>
        <!-- Логин пользователя END -->
        <!-- Пароль пользователя -->
        <div class="form-group">
            <label for="psswd">Пароль</label>
            <input type="password" class="form-control" id="psswd" />
        </div>
        <!-- Пароль пользователя END -->
        <!-- Фамилия пользователя -->
        <div class="form-group">
            <label for="surname">Фамилия</label>
            <input type="text" class="form-control" id="surname" />
        </div>
        <!-- Фамилия пользователя END -->
        <!-- Имя -->
        <div class="form-group">
            <label for="firstname">Имя</label>
            <input type="text" class="form-control" id="firstname" />
        </div>
        <!-- Имя END -->
        <!-- Отчество -->
        <div class="form-group">
            <label for="secondname">Отчество</label>
            <input type="text" class="form-control" id="secondname" />
        </div>
        <!-- Отчество END -->
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="rememberUser">
            <label class="form-check-label" for="rememberUser">Запомнить меня</label>
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block" name="reg">Зарегистрироваться</button>
    </form>
</div>
</body>
</html>
