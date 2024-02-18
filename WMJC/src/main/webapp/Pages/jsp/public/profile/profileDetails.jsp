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
    <title>WMJC - ${sessionScope.profile.profileName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Pages/css/perfilDetalis.css">
</head>
    <body>
        <div class="header">
            <c:if test="${sessionScope.loggedUser != null}">
                <div class="menu">

                    <h2>${sessionScope.profile.profileName}</h2>

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

            <div class="imgName">
                <div class="imgJogo">
                    <img src="${sessionScope.profile.picProfile}" alt="">
                </div>
                <div class="tituloGame">
                    <h1 class="tituloGame">${sessionScope.profile.profileName}</h1>
                </div>
            </div>

            <div class="botaoA">
                <c:if test="${sessionScope.loggedUser.id == sessionScope.profile.idDoUser}">
                    <a class="atagB" href="/perfilInfoEdit?id=${sessionScope.loggedUser.id}">
                        Editar Perfil
                    </a>
                </c:if>
            </div>

            <div class="atividadeRecente">
                <div class="atividadeRecenteH1">
                    <h1>Atividade recente</h1>
                </div>

                <div class="atividades">
                    <c:forEach var="activity" items="${activitys}">
                        <a class="atividadesA" href="/jogo-detalhes?id=${activity.id}">
                            <div class="atividadeRecenteCom">
                                <div class="atividadeRecenteComImg">
                                    <img src="${activity.bannerGamer}" width="200px" height="200px">
                                </div>

                                <div class="atividadeRecenteComH2">
                                    <h2>${activity.nameGame}</h2>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>

            <div class="group">
                <c:if test="${sessionScope.loggedUser != null}">
                    <form action="/profileComment" method="post">
                        <input class="comentariosGameIn" type="text" name="comment" placeholder="Comente aqui">
                        <span class="highlight"></span>
                        <span class="bar"></span>
                        <input type="hidden" name="idDoUser" value="${sessionScope.loggedUser.id}">
                        <input type="hidden" name="idPerfil" value="${sessionScope.profile.idDoUser}">
                        <input type="submit" value="Comentar">
                    </form>
                </c:if>
            </div>

            <div class="comentariosGame">
                <h2>Comentários</h2>
                <c:forEach var="commentProfile" items="${comments}">
                    <div class="comentariosGameDiv">

                        <div class="perfilUser">
                            <a class="comentariosGameA" href="/perfil-detalhes?id=${commentProfile.userProfile.idDoUser}">
                                <img class="imgComent" src="${commentProfile.userProfile.picProfile}" alt="" width="100px">
                                <h3>${commentProfile.userProfile.profileName}</h3>
                            </a>
                            <p class="comentariosGameP"> ${commentProfile.commentProfile.comment}</p>
                        </div>

                        <c:if test="${sessionScope.loggedUser.id == sessionScope.profile.idDoUser || sessionScope.loggedUser.id == commentProfile.userProfile.idDoUser}">
                            <form action="/profileDeleteComment" method="post">
                                <input type="hidden" name="id" value="${commentProfile.commentProfile.id}">
                                <input type="hidden" name="idDoDonoPerfil" value="${sessionScope.profile.idDoUser}">
                                <button class="comentariosGameDeletar" type="submit">
                                    <h4 class="comentariosGameDeletarH2">Deletar</h4>
                                </button>

                            </form>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="footerGame">
            <p>© 2024 by WMJC</p>
        </div>
    </body>
</html>
