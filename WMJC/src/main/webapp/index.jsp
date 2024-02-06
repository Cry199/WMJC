<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 16/11/2023
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  rel="stylesheet" href="/Pages/css/gameCssStyles.css">
</head>
<body>
    <c:if test="${sessionScope.loggedUser != null}">
        <div class="menu">
            <a href="/index">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/login/login.jsp">Login</a>
            <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
            <a href="/logout">Sair</a>
            </div>
        </div>
    </c:if>

    <c:if test="${sessionScope.loggedUser == null}">
        <div class="menu">
            <a href="/index">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/login/login.jsp">Login</a>
            <a href=""></a>
            <a href="#"></a>
        </div>
        </div>
    </c:if>

    <span>${requestScope.message}</span>

    <div class="content">
        <h1>WELCOME TO WMJC</h1>

        <a href="WEB-INF/Pages/Jsp/public/games.jsp">
            <form action="/Jogos" method="get">
                <button class="" type="submit">Jogos</button>
            </form>
        </a>
    </div>

</body>
</html>