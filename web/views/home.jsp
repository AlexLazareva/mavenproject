<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Аутентификация</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/index.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/vendor/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/build/styles/home-page.css" />
</head>
<body>
<div class="page">
    <jsp:include page="partials/menu.jsp" />
    <main>
        <div class="page__home">
            <h1>Здравствуйте, <span>${sessionScope.surname}!</span></h1>
            <form id="profileForm" action="enterSystem.jsp" method="post">
                <button class="btn btn-info btn-lg" id="profileButton" type="submit" name="profileButton">
                    <svg class="bi bi-wallet" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M1.5 3a.5.5 0 00-.5.5v2h5a.5.5 0 01.5.5c0 .253.08.644.306.958.207.288.557.542 1.194.542.637 0 .987-.254 1.194-.542.226-.314.306-.705.306-.958a.5.5 0 01.5-.5h5v-2a.5.5 0 00-.5-.5h-13zM15 6.5h-4.551a2.678 2.678 0 01-.443 1.042C9.613 8.088 8.963 8.5 8 8.5c-.963 0-1.613-.412-2.006-.958A2.679 2.679 0 015.551 6.5H1v6a.5.5 0 00.5.5h13a.5.5 0 00.5-.5v-6zm-15-3A1.5 1.5 0 011.5 2h13A1.5 1.5 0 0116 3.5v9a1.5 1.5 0 01-1.5 1.5h-13A1.5 1.5 0 010 12.5v-9z" clip-rule="evenodd"/>
                    </svg>
                    В систему
                </button>
            </form>
        </div>
    </main>
</div>
</body>
</html>
