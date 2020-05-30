<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Перевод</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/index.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/home-page.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/vendor/bootstrap.css" />
</head>
<body>
<div class="container-fluid container-page">
    <form id="payForm" class="page__form form-signin" action="${pageContext.servletContext.contextPath}/initClientsTransfer" method="post">
        <select class="page__form-control form-control" name="toClient">
            <option selected disabled>Выберите клиента</option>
            <c:forEach items="${allClients}" var="client">
                <option value="${client.account.id}">${client.firstname}</option>
            </c:forEach>
        </select>
        <input type="number" id="paySum" name="transferSum" class="page__form-field" placeholder="Сумма" />
        <button type="submit" class="btn btn-lg btn-primary">Оплатить</button>
    </form>
</div>
</body>
</html>
