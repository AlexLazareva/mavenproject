<%@ page contentType="text/html;charset=utf-8" %>
<%
    String header = "Apache Tomcat";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Регистрация</title>
    <link rel="stylesheet" href="styles/index.css">
</head>
<body>
    <h1><%= header %></h1>
    <p>Today <%= new java.util.Date() %></p>
    <jsp:include page="auth.jsp" />
</body>
</html>