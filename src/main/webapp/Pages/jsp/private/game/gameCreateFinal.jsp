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
        </div>
    </c:if>

    <br>

    <div class="formContainer">
        <a class="botao" href="/gameCreateFinal">Criar Game</a>
        <a class="botao" href="/gameListAtual?nameTable=${nameTable}">Listar o game Atual - ${nameTable}</a>
    </div>

    <c:if test="${sessionScope.clickUser == 'listGame'}">
        <h1>Lista de Games</h1>
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
    </c:if>

    <c:if test="${sessionScope.clickUser == 'createGame'}">
        <h1>Criar Game</h1>

        <form action="/gameCreateFinal" method="post">

            <label for="imgText">Imagem da Linha: </label>
            <input type="text" id="imgText" name="imgText">

            <br>

            <label for="texto">Texto: </label>
            <input type="text" id="texto" name="texto">

            <br>

            <label for="op1">Opção nome: </label>
            <input type="text" id="op1" name="op1">

            <br>

            <label for="ref1">Referencia do id do texto (op1):  </label>
            <input type="number" id="ref1" name="ref1">

            <br>

            <label for="op2">Opção 2 nome: </label>
            <input type="text" id="op2" name="op2">

            <br>

            <label for="ref2">Referencia do id do texto (op2):  </label>
            <input type="number" id="ref2" name="ref2">

            <br>

            <label for="op3">Opção 3 nome: </label>
            <input type="text" id="op3" name="op3">

            <br>

            <label for="ref3">Referencia do id do texto (op3):  </label>
            <input type="number" id="ref3" name="ref3">

            <br>

            <br>

            <input type="hidden" id="nameTable" name="nameTable" value="${nameTable}">

            <button type="submit">Criar jogo</button>
        </form>
    </c:if>
</body>
</html>
