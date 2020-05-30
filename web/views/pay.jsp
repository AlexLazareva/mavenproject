<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оплата</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/index.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/home-page.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/vendor/bootstrap.css" />
</head>
<body>
<div class="container-fluid container-page">
    <form id="payForm" class="page__form form-signin" action="${pageContext.servletContext.contextPath}/pay" method="post">
        <input type="number" id="payTargetCount" name="payTargetCount" class="page__form-field" placeholder="Целевой счет" />
        <input type="number" id="paySum" name="paySum" class="page__form-field" placeholder="Сумма" />
        <button type="submit" class="btn btn-lg btn-primary">Оплатить</button>
    </form>
</div>
</body>
</html>
