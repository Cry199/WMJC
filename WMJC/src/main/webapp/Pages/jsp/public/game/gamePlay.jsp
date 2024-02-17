<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 11/02/2024
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>WMJC</title>
</head>
<body>
    <div class="header">
        <c:if test="${sessionScope.loggedUser != null}">
            <div class="menu">
                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="Pages/jsp/public/login/login.jsp">Login</a>
                <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
                <a href="/logout">Sair</a>
            </div>
        </c:if>

        <c:if test="${sessionScope.loggedUser == null}">
            <div class="menu">
                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="Pages/jsp/public/login/login.jsp">Login</a>
            </div>
        </c:if>
    </div>

    <div class="content">
        <div class="image">
            <img src="${Jogo.image}" alt="">
        </div>

        <div class="Textos">
            <h1 class="texto">${Jogo.texto}</h1>
        </div>

        <form action="/gamePlay" id="" method="post">

            <input type="hidden" name="id" value="${Jogo.ref1}">
            <input type="hidden" class="nameTable" name="nameTable" value="${sessionScope.tabelaGame}">

            <div>
                <button type="submit">${Jogo.op1}</button>
            </div>
        </form>

        <form action="/gamePlay" id="" method="post">

            <input type="hidden" name="id" value="${Jogo.ref2}">
            <input type="hidden" class="nameTable" name="nameTable" value="${sessionScope.tabelaGame}">

            <div>
                <button type="submit">${Jogo.op2}</button>
            </div>
        </form>

        <form action="/gamePlay" id="" method="post">

            <input type="hidden" name="id" value="${Jogo.ref3}">
            <input type="hidden" class="nameTable" name="nameTable" value="${sessionScope.tabelaGame}">

            <div>
                <button type="submit">${Jogo.op3}</button>
            </div>
        </form>
    </div>

    <div class="footer">
        <p>WMJC 2023</p>
    </div>

</body>
</html>
