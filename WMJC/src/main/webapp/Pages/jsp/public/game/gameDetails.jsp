<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 28/01/2024
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Games - ${sessionScope.game.nameGame}</title>
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
    </c:if>

    <c:if test="${sessionScope.loggedUser == null}">
        <div class="menu">
            <a href="/index">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/public/login/login.jsp">Login</a>
            <a href=""></a>
            <a href="#"></a>
        </div>
    </c:if>

    <img src="${sessionScope.game.bannerGamer}" alt="" width="300px" height="500">
    <h1>${sessionScope.game.nameGame}</h1>

    <c:if test="${sessionScope.loggedUser != null && sessionScope.loggedUser.id == sessionScope.game.idUser}">
        <a href="/gameInfoEdit?id=${sessionScope.loggedUser.id}">Editar Jogo</a>
    </c:if>

    <c:if test="${sessionScope.loggedUser != null && sessionScope.loggedUser.id == sessionScope.game.idUser}">
        <a href="/gameListAtual?nameTable=${sessionScope.game.nameTable}">Criar ou Editar o Game</a>
    </c:if>

    <c:if test="${sessionScope.nameTable == sessionScope.game.nameTable}">
        <a href="/gamePlay?nameTable=${sessionScope.nameTable}&id=1" onclick="enviarDadosHistorico(${sessionScope.loggedUser.id}, ${sessionScope.game.id});return true;">Jogar</a>
    </c:if>

    <c:if test="${sessionScope.loggedUser != null}">
        <script>
            function enviarDadosHistorico(idUser, idGame) {
                var xhttp = new XMLHttpRequest();
                xhttp.open("POST", "/GameHistoricoServlet", true);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("idUser=" + idUser + "&idGame=" + idGame);
            }
        </script>
    </c:if>

    <c:if test="${sessionScope.nameTable != sessionScope.game.nameTable}">
        <h2>${sessionScope.nameTable}</h2>
    </c:if>

    <h2>Descrição:</h2>
    <h3>${sessionScope.game.descGame}</h3>

    <c:if test="${sessionScope.loggedUser != null}">
        <form action="/gameComment" method="post">
            <input type="text" name="comment" placeholder="Comente aqui">
            <input type="hidden" name="idDoUser" value="${sessionScope.loggedUser.id}">
            <input type="hidden" name="idJogo" value="${sessionScope.game.id}">
            <input type="submit" value="Comentar">
        </form>
    </c:if>

    <h2>Comentários</h2>
    <c:forEach var="commentUserProfile" items="${comments}">
        <div>
            <img src="${commentUserProfile.userProfile.picProfile}" alt="" width="100px">
            <a href="/perfil-detalhes?id=${commentUserProfile.userProfile.idDoUser}">${commentUserProfile.userProfile.profileName}</a>
            <p>${commentUserProfile.comment.commentGame}</p>
            <c:if test="${sessionScope.loggedUser.id == commentUserProfile.userProfile.idDoUser || sessionScope.loggedUser.id == sessionScope.game.idUser}">
                <form action="/gameDeleteComment" method="post">
                    <input type="hidden" name="id" value="${commentUserProfile.comment.id}">
                    <input type="hidden" name="idGame" value="${sessionScope.game.id}">
                    <button type="submit">Deletar</button>
                </form>
            </c:if>
        </div>
    </c:forEach>
</body>
</html>
