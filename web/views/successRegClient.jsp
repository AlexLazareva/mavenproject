<%--
  Created by IntelliJ IDEA.
  User: Alex_Lazareva
  Date: 05.05.2020
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>${sessionScope.firstname} успешно зарегистрирован</h1>
</div>
<form id="clientSuccessRegistrationForm" action="enterSystem.jsp" method="post">
    <input type="submit" name="enterSystem" value="Перейти в систему"/>
</form>
</body>
</html>
