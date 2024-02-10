<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 09/02/2024
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../public/css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>
<c:if test="${sessionScope.loggedUser != null}">
    <div class="menu">
        <a href="/index">Home</a>
        <a href="/Jogos">Jogos</a>
        <a href="Pages/jsp/public/login/login.jsp">Login</a>
        <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
        <a href="/logout">Sair</a>
    </div>
    </div>
</c:if>

<c:if test="${sessionScope.loggedUser == null}">
    <div class="menu">
        <a href="/index">Home</a>
        <a href="/Jogos">Jogos</a>
        <a href="Pages/jsp/public/login/login.jsp">Login</a>
        <a href=""></a>
        <a href="#"></a>
    </div>
    </div>
</c:if>

<h1>Criar Game</h1>

<form action="/create-game" method="post">

    <label for="nomeGame">Nome do Jogo: </label>
    <input type="text" id="nomeGame" name="nomeGame">

    <br>

    <label for="description">Descrição do Jogo: </label>
    <input type="text" id="description" name="description">

    <br>

    <label for="imgGame">Imagem do Jogo: </label>
    <input type="text" id="imgGame" name="imgGame">

    <br>

    <input type="hidden" id="idUser" name="idUser" value="${sessionScope.idDoUser}">

    <button type="submit">Criar jogo</button>
</form>
</body>
</html>