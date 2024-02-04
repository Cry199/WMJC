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
    <link type="text/css" rel="stylesheet" href="../../css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
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
    </div>
    </c:if>

    <c:if test="${sessionScope.loggedUser == null}">
        <div class="menu">
            <a href="index.jsp">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/login/login.jsp">Login</a>
            <a href=""></a>
            <a href="#"></a>
        </div>
        </div>
    </c:if>

        <h1>Games</h1>

        <c:forEach var="game" items="${games}">
            <div>
                <img src="${game.bannerGamer}" alt="">
                <a href="/jogo-detalhes?id=${game.id}">${game.nameGame}</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
