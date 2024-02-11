<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 04/02/2024
  Time: 04:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>${sessionScope.profile.profileName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="css/generalStyles.css">
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
            <a href="Pages/public/jsp/login/login.jsp">Login</a>
            <a href=""></a>
            <a href="#"></a>
        </div>
        </div>
    </c:if>

    <br>

    <h6>${requestScope.erroUpdate}</h6>

    <form action="/gameInfoEdit" id="" method="post">
        <div class="GameIMG">
            <img src="${sessionScope.game.bannerGamer}" alt="" width="100px">
            <input type="text" name="picGame" id="picGame" value="${sessionScope.game.bannerGamer}" required>
            <input type="hidden" name="" value="picGame">
        </div>

        <br>

        <div class="gameInfo">
            <h2>${sessionScope.game.nameGame}</h2>
            <input type="text" name="gameName" id="gameName" value="${sessionScope.game.nameGame}" required>
            <input type="hidden" name="" value="gameName">
        </div>

        <br>

        <div class="gameDescription">
            <h2>${sessionScope.game.descGame}</h2>
            <input type="text" name="aa" id="gameDesc" value="${sessionScope.game.descGame}" required>
            <input type="hidden" name="" value="descGame">
        </div>

        <br>

        <input type="hidden" name="id" value="${sessionScope.game.id}">

        <button>Alterar</button>
    </form>

    <br>

    <form action="/gameInfoEditDelete" id="" method="post">
        <input type="hidden" name="id" value="${sessionScope.game.id}">
        <button>Deletar</button>
    </form>
</body>
</html>
