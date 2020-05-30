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
    <div class="page__wrapper">
        <div class="main-row row">
            <div class="col-3">
                <ul class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <li class="nav-item">
                        <a class="nav-link" href="pay.jsp" target="payOperationFrame">Оплата</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="transfer.jsp" target="payOperationFrame">Перевод</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="withdrawal.jsp" target="payOperationFrame">Вывод</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="replenish.jsp" target="payOperationFrame">Пополнение</a>
                    </li>
                </ul>
            </div>
            <div class="col-9">
                <div class="tab-content">
                    <iframe frameborder="0" name="payOperationFrame" width="100%" height="100%"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
