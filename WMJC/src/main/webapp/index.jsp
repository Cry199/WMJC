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
    <title>Login</title>
</head>
<body>

<form action="/tipoLogin" method="post">

    <span>${requestScope.message}</span>

    <br>

    <label for="username">Username</label>
    <input type="text" id="username" name="username">

    <br>

    <label for="password">Password</label>
    <input type="password" id="password" name="password">

    <button type="submit">Login</button>

</form>

<div>
    <h1>Games</h1>
    <table>
        <tr>
            <th>Nome do Jogo</th>
            <th>Tabela do Jogo</th>
            <th>Descrição do Jogo</th>
            <th>Capa</th>

        </tr>
        <c:forEach var="game" items="${games}">
            <tr>
                <td>${game.nameGame}</td>
                <td>${game.nameTable}</td>
                <td>${game.descGame}</td>
                <td>${game.bannerGamer}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>