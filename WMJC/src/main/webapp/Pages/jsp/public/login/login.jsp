<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 21/01/2024
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  rel="stylesheet" href="/Pages/css/loginStyles1.css">
</head>
<body>

    <div class="header">
        <c:if test="${sessionScope.loggedUser != null}">
            <div class="menu">
                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="#">Login</a>
                <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
                <a href="/logout">Sair</a>
            </div>
        </c:if>

        <c:if test="${sessionScope.loggedUser == null}">
            <div class="menu">
                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="#">Login</a>
            </div>
        </c:if>
    </div>

    <div class="content">
        <c:if test="${sessionScope.clickUser != 'cadastro'}">
            <div class="loginCont">
                <h1 class="loginContH1">Login</h1>

                <div class="loginContFormP1">
                    <form class="loginContForm" action="/tipoLogin" method="post">

                        <label class="loginContFormLabel" for="username">Email: </label>
                        <input class="loginContFormInput" type="text" id="username" name="username">

                        <label class="loginContFormLabel" for="password">Senha: </label>
                        <input class="loginContFormInput" type="password" id="password" name="password">

                        <button class="loginContFormButton" type="submit">Login</button>

                        <span class="loginConSpan">${requestScope.message}</span>

                        <a class="loginContA" href="/tipoCadastro">Cadastrar</a>
                    </form>
                </div>
            </div>
        </c:if>

        <c:if test="${sessionScope.clickUser == 'cadastro'}">
            <div class="loginCont">
                <h1 class="loginContH1">Login</h1>

                <div class="loginContFormP1">
                    <form class="loginContForm" action="/tipoCadastro" method="post">

                        <label class="loginContFormLabel" for="nome">Nome: </label>
                        <input class="loginContFormInput" type="text" id="nome" name="nome">

                        <label class="loginContFormLabel" for="sobrenome">Sobrenome: </label>
                        <input class="loginContFormInput" type="text" id="sobrenome" name="sobrenome">

                        <label class="loginContFormLabel" for="senha">Senha: </label>
                        <input class="loginContFormInput" type="password" id="senha" name="senha">

                        <label class="loginContFormLabel" for="email">Email: </label>
                        <input class="loginContFormInput" type="text" id="email" name="email">

                        <button class="loginContFormButton" type="submit">Cadrastro</button>

                        <span class="loginConSpan">${requestScope.message}</span>

                        <a class="loginContA" href="/tipoLogin">Login</a>
                    </form>
                </div>
            </div>
        </c:if>
    </div>

    <div class="footer">
        <p>WMJC - 2024</p>
    </div>
</body>
</html>
