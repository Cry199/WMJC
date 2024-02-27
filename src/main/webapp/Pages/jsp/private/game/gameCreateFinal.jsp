<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 10/02/2024
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.loggedUser.username}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Pages/css/perfilDetalis.css">
</head>
    <c:if test="${sessionScope.loggedUser != null}">
    <body style="background-image: url(https://i.pinimg.com/originals/62/89/6a/62896ae0865746ec3e3cbe84b1b10add.gif)">
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
                    <a href="Pages/jsp/public/login/login.jsp">Login</a>
                </div>
            </c:if>
        </div>

        <c:if test="${sessionScope.loggedUser != null}">
            <div class="content">

                <c:if test="${sessionScope.clickUser == 'createGame'}">
                    <div class="imgName">
                        <h1>Criar Game</h1>
                    </div>
                </c:if>

                <c:if test="${sessionScope.clickUser == 'listGame'}">
                    <div class="imgName">
                        <h1>Lista de Games</h1>
                    </div>
                </c:if>

                <div class="botaoA">
                    <a class="atagB" href="/gameCreateFinal">Criar Game</a>
                    <a class="atagB" href="/gameListAtual?nameTable=${nameTable}">Listar o game Atual</a>
                </div>

                <c:if test="${sessionScope.clickUser == 'listGame'}">
                    <div class="comentariosGame">
                        <div class="table-responsive hide" id="gameList">
                            <table>
                                <tr>
                                    <th> ID:</th>
                                    <th> Texto:</th>
                                    <th> OP1:</th>
                                    <th> REF1:</th>
                                    <th> OP2:</th>
                                    <th> REF2:</th>
                                    <th> OP3:</th>
                                    <th> REF3:</th>
                                    <th> Imagem:</th>
                                </tr>
                                <c:forEach var="game" items="${gameList}">
                                    <tr>
                                        <td>${game.id}</td>
                                        <td>${game.texto}</td>
                                        <td>${game.op1}</td>
                                        <td>${game.ref1}</td>
                                        <td>${game.op2}</td>
                                        <td>${game.ref2}</td>
                                        <td>${game.op3}</td>
                                        <td>${game.ref3}</td>
                                        <td>
                                            <img src="${game.image}" alt="imagem" width="100px" height="100px">
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </c:if>

                <c:if test="${sessionScope.clickUser == 'createGame'}">
                    <div class="comentariosGame">
                        <form action="/gameCreateFinal" method="post">

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Imagem da Linha:</h2>
                                <input class="inputTextImg" type="text" id="imgText" name="imgText">
                            </div>

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Texto:</h2>
                                <input class="inputTextImg" type="text" id="texto" name="texto">
                            </div>

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Opção 1 nome: </h2>
                                <input class="inputTextImg" type="text" id="op1" name="op1">
                            </div>

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Referencia do id do texto (op1):  </h2>
                                <input class="inputTextImg" type="number" id="ref1" name="ref1">
                            </div>

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Opção 2 nome: </h2>
                                <input class="inputTextImg" type="text" id="op2" name="op2">
                            </div>

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Referencia do id do texto (op2):  </h2>
                                <input class="inputTextImg" type="number" id="ref2" name="ref2">
                            </div>

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Opção 3 nome: </h2>
                                <input class="inputTextImg" type="text" id="op3" name="op3">
                            </div>

                            <div class="profileInfo">
                                <h2 class="profileInfoH2">Referencia do id do texto (op3):  </h2>
                                <input class="inputTextImg" type="number" id="ref3" name="ref3">
                            </div>

                            <input type="hidden" id="nameTable" name="nameTable" value="${nameTable}">

                            <button class="comentariosGameDeletar" type="submit">
                                <h4 class="comentariosGameDeletarH2">Criar linha do jogo</h4>
                            </button>
                        </form>
                    </div>
                </c:if>
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
