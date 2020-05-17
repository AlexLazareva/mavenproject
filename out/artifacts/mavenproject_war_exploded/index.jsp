<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Регистрация</title>
    <link rel="stylesheet" href="build/styles/index.css" />
    <link rel="stylesheet" href="build/vendor/bootstrap.css" />
</head>
<body>
<div class="container-fluid container-page">
    <form class="auth form-signin" action="index" method="post">
        <h2>Добро пожаловать в платежную систему</h2>
        <div class="auth__logo">
            <img src="${pageContext.servletContext.contextPath}/images/pound.svg" alt="paysystem" />
            <p>SOME PAYSYSTEM</p>
        </div>
        <p>Для того, чтобы продолжить работу, необходимо "Войти" или "Зарегистрироваться"</p>
        <div class="buttons-container">
            <button type="submit" class="btn btn-lg btn-primary btn-block" name="enter">Войти</button>
            <button type="submit" class="btn btn-lg btn-primary btn-block" name="reg">Зарегистрироваться</button>
        </div>
    </form>
</div>
</body>
</html>