
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter</title>
</head>
<body>
<form class="auth" action="${pageContext.servletContext.contextPath}/auth" method="post">
    <input type="text" id="login" class="auth__field" placeholder="Login" />
    <input type="password" id="password" class="auth__field" placeholder="Password" />
    <input type="submit" class="btn btn-lg btn-primary" />
</form>
</body>
</html>
