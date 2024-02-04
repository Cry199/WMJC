<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 21/01/2024
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../../css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>
    <form action="/tipoLogin" method="post">

        <span>${requestScope.message}</span>

        <br>

        <label for="username">Email: </label>
        <input type="text" id="username" name="username">

        <br>

        <label for="password">Senha: </label>
        <input type="password" id="password" name="password">

        <button type="submit">Login</button>

    </form>
    <form action="/tipoCadastro" method="post">

        <span>${requestScope.message}</span>

        <br>

        <label for="nome">Nome </label>
        <input type="text" id="nome" name="nome">

        <br>

        <br>

        <label for="sobrenome">Sobrenome </label>
        <input type="text" id="sobrenome" name="sobrenome">

        <br>

        <br>

        <label for="senha">Senha: </label>
        <input type="password" id="senha" name="senha">

        <br>

        <label for="email">Email: </label>
        <input type="text" id="email" name="email">

        <button type="submit">Cadrastro</button>

    </form>
</body>
</html>
