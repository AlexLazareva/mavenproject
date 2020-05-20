<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успешный вход</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/index.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/vendor/bootstrap.css" />
</head>
<body>
<div class="page">
    <jsp:include page="partials/menu.jsp" />
    <div>
        <div class="topnav">
            <a href="pay.jsp" target="payOperationFrame">Оплата</a>
            <a href="../initClientsTransfer" target="payOperationFrame">Перевод</a>
            <a href="withdrawal.jsp" target="payOperationFrame">Вывод</a>
            <a href="replenish.jsp" target="payOperationFrame">Пополнение</a>
        </div>
        <iframe frameborder="0" name="payOperationFrame" width="100%" height="200px"/>
    </div>
</div>
</body>
</html>
