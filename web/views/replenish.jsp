
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пополнение</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/index.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/home-page.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/vendor/bootstrap.css" />
</head>
<body>
<div class="container-fluid container-page">
    <form id="payForm" class="page__form form-signin" action="${pageContext.servletContext.contextPath}/replenish" method="post">
        <input type="number" id="paySum" name="replenish_sum" class="page__form-field" min="1" placeholder="Сумма" />
        <button type="submit" class="btn btn-lg btn-primary">Пополнить</button>
    </form>
</div>
</body>
</html>
