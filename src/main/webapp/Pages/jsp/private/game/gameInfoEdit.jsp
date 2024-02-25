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
    <body style="background-image: url(${sessionScope.game.bannerGamer})">
    </c:if>
    <c:if test="${sessionScope.loggedUser == null}">
    <body>
    </c:if>
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
                    <a href="Pages/public/jsp/login/login.jsp">Login</a>
                </div>
            </c:if>
        </div>

        <c:if test="${sessionScope.loggedUser != null}">
            <div class="content">

                <div class="imgName">
                    <div class="imgJogo">
                        <img src="${sessionScope.game.bannerGamer}" alt="">
                    </div>
                    <div class="tituloGame">
                        <h1 class="tituloGame">${sessionScope.game.nameGame}</h1>
                    </div>
                    <div class="tituloGameP">
                        <p>${sessionScope.game.descGame}</p>
                    </div>
                </div>

                <div class="spanErro">
                    <span>${requestScope.erroUpdate}</span>
                </div>

                <div class="comentariosGame">
                    <form action="/gameInfoEdit" method="post">
                        <div class="GameIMG">
                            <img src="${sessionScope.game.bannerGamer}" alt="" width="100px">
                            <input type="text" name="picGame" id="picGame" value="${sessionScope.game.bannerGamer}" required>
                            <input type="hidden" name="" value="picGame">
                        </div>

                        <div class="gameInfo">
                            <h2>${sessionScope.game.nameGame}</h2>
                            <input type="text" name="gameName" id="gameName" value="${sessionScope.game.nameGame}" required>
                            <input type="hidden" name="" value="gameName">
                        </div>

                        <div class="gameDescription">
                            <h2>${sessionScope.game.descGame}</h2>
                            <input type="text" name="aa" id="gameDesc" value="${sessionScope.game.descGame}" required>
                            <input type="hidden" name="" value="descGame">
                        </div>

                        <input type="hidden" name="id" value="${sessionScope.game.id}">

                        <button class="comentariosGameDeletar" type="submit">
                            <h4 class="comentariosGameDeletarH2">Alterar</h4>
                        </button>
                    </form>

                    <form action="/gameInfoEditDelete" method="post">
                        <input type="hidden" name="id" value="${sessionScope.game.id}">
                        <input type="hidden" name="nameTable" value="${sessionScope.game.nameTable}">
                        <button class="comentariosGameDeletar" type="submit">
                            <h4 class="comentariosGameDeletarH2">Deletar</h4>
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
            <p>© 2024 WMJC</p>
        </div>
    </body>
</html>
