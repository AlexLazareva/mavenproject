<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль пользователя</title>
</head>
<body>
Профиль пользователя
<div>
    <span>"${sessionScope.login}"</span>
    <span>"${sessionScope.firstname}"</span>
    <span>"${sessionScope.secondname}"</span>
    <span>"${sessionScope.surname}"</span>
</div>
</body>
</html>
