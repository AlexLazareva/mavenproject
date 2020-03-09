<%@ page contentType="text/html;charset=utf-8" %>
<%
    String header = "Apache Tomcat";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Регистрация</title>
</head>
<body>
    <h1><%= header %></h1>
    <p>Today <%= new java.util.Date() %></p>
    <form action="auth.jsp" method="post">
        <input type="text" id="login" placeholder="Введите логин" />
        <input type="text" id="password" placeholder="Введите пароль" />
        <input type="submit">
    </form>
</body>
</html>