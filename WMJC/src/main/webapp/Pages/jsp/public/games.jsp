<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 28/01/2024
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC - Games</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Pages/css/gameStyles.css">
</head>
<body>

<div>
    <c:if test="${sessionScope.loggedUser != null}">
        <div class="menu">
            <a href="index.jsp">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/login/login.jsp">Login</a>
            <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
            <a href="/logout">Sair</a>
        </div>
    </c:if>

    <c:if test="${sessionScope.loggedUser == null}">
        <div class="menu">
            <a href="index.jsp">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/login/login.jsp">Login</a>
            <a href="#"></a>
            <a href="#"></a>
        </div>
    </c:if>
</div>
    <h2>trending games</h2>
    <div class="cont">
        <c:forEach var="game" items="${games}">
            <div class="igmDiv" style="background-image: url(${game.bannerGamer});">
                <div class="">
                    <h2>${game.nameGame}</h2>
                    <p>${game.descGame}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
