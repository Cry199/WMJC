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
    <title>${sessionScope.profile.profileName}</title>
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
        </c:if>

        <img src="${sessionScope.profile.picProfile}" alt="" width="300px" height="500">

        <br>

        <c:if test="${sessionScope.loggedUser.id == sessionScope.profile.idDoUser}">
            <a href="/perfilInfoEdit?id=${sessionScope.loggedUser.id}">Editar Perfil</a>
        </c:if>

        <br>

        <h1>${sessionScope.profile.profileName}</h1>

        <c:if test="${sessionScope.loggedUser != null}">
            <form action="/profileComment" method="post">
                <input type="text" name="comment" placeholder="Comente aqui">
                <input type="hidden" name="idDoUser" value="${sessionScope.loggedUser.id}">
                <input type="hidden" name="idPerfil" value="${sessionScope.profile.idDoUser}">
                <input type="submit" value="Comentar">
            </form>
        </c:if>

        <h2>Comentários</h2>
        <c:forEach var="commentProfile" items="${comments}">
            <div>
                <img src="${commentProfile.userProfile.picProfile}" alt="" width="100px">
                <a href="/perfil-detalhes?id=${commentProfile.userProfile.idDoUser}">${commentProfile.userProfile.profileName}</a>
                <p>${commentProfile.commentProfile.comment}</p>
                <c:if test="${sessionScope.loggedUser.id == sessionScope.profile.idDoUser || sessionScope.loggedUser.id == commentProfile.userProfile.idDoUser}">
                    <form action="/profileDeleteComment" method="post">
                        <input type="hidden" name="idComment" value="${commentProfile.commentProfile.comment}">
                        <input type="hidden" name="idPerfil" value="${commentProfile.commentProfile.idPerfil}">
                        <input type="hidden" name="idUser" value="${commentProfile.userProfile.idDoUser}">
                        <input type="hidden" name="idDoDonoPerfil" value="${sessionScope.profile.idDoUser}">
                        <button type="submit">Deletar</button>
                    </form>
                </c:if>
            </div>
        </c:forEach>
    </body>
</html>
