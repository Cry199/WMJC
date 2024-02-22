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
    <link rel="stylesheet" href="/Pages/css/perfilDetalis.css">
</head>
    <c:if test="${sessionScope.loggedUser != null}">
    <body style="background-image: url(${sessionScope.profile.picProfile})">
    </c:if>
    <c:if test="${sessionScope.loggedUser == null}">
    <body>
    </c:if>
        <div class="header">
            <c:if test="${sessionScope.loggedUser != null}">
                <div class="menu">
                    <a href="/index">Home</a>
                    <a href="/Jogos">Jogos</a>
                    <a href="Pages/js/public/login/login.jsp">Login</a>
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

        <c:if test="${sessionScope.loggedUser != null}">
            <div class="content">

                <div class="imgName">
                    <div class="imgJogo">
                        <img src="${sessionScope.profile.picProfile}" alt="">
                    </div>
                    <div class="tituloGame">
                        <h1 class="tituloGame">${sessionScope.profile.profileName}</h1>
                    </div>
                </div>

                <div class="spanErro">
                    <span>${requestScope.erroUpdate}</span>
                </div>

                <div class="comentariosGame">
                    <form action="/perfilInfoEdit" method="post">

                        <div class="profilIgm">
                            <img class="updateImg" src="${sessionScope.profile.picProfile}" alt="" width="200px" height="100px">
                            <h2 class="profileInfoH2">Imagem do perfil:</h2>
                            <input class="inputTextImg" type="text" name="picProfile" value="${sessionScope.profile.picProfile}" required>
                            <input type="hidden" name="fieldToUpdate" value="picProfile">
                        </div>

                        <div class="profileInfo">
                            <h2 class="profileInfoH2">Nome do Perfil: ${sessionScope.profile.profileName}</h2>
                            <input class="inputTextImg" type="text" name="profileName" value="${sessionScope.profile.profileName}" required>
                            <input type="hidden" name="fieldToUpdate" value="profileName">
                        </div>

                        <input type="hidden" name="id" value="${sessionScope.loggedUser.id}">

                        <button class="comentariosGameDeletar" type="submit">
                            <h4 class="comentariosGameDeletarH2">Alterar</h4>
                        </button>
                    </form>
                </div>
            </div>
        </c:if>

        <c:if test="${sessionScope.loggedUser == null}">
            <div class="content">
                <div class="center">
                    <div class="centerRow">
                        <h1>Usuário não logado</h1>
                    </div>

                    <div class="centerRow1">
                        <img src="https://i.pinimg.com/originals/78/47/ec/7847ecea51ed5dab456928bc9bf5213a.gif" alt="">
                    </div>
                </div>
            </div>
        </c:if>

        <div class="footerGame">
            <p>© 2024 by WMJC</p>
        </div>
    </body>
</html>
