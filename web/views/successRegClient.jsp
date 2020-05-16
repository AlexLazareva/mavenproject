<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>${sessionScope.firstname} успешно зарегистрирован</h1>
</div>
<form id="clientSuccessRegistrationForm" action="${pageContext.servletContext.contextPath}/enterSystem.jsp" method="post">
    <input type="submit" name="enterSystem" value="Перейти в систему"/>
</form>
</body>
</html>
