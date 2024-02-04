<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 04/02/2024
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>${sessionScope.profile.profileName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../public/css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
    <body>

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
        </c:if>

        <form action="/perfil-criar" id="" method="post">

            <div class="profilIgm">
                <input type="text" name="picProfile" id="picProfile" value="Foto do Perfil" required>
                <input type="hidden" name="fieldToUpdate" value="picProfile">
            </div>

            <br>

            <div class="profileInfo">
                <h2>${sessionScope.profile.profileName}</h2>
                <input type="text" name="profileName" id="username" value="Nome Do Perfil" required>
                <input type="hidden" name="fieldToUpdate" value="profileName">
            </div>

            <br>

            <input type="hidden" name="id" value="${sessionScope.loggedUser.id}">

            <button>Alterar</button>
        </form>
    </body>
</html>
