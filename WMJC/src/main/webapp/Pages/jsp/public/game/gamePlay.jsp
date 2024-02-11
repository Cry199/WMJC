<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 11/02/2024
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>${r}</title>
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

    <script>
        function submitForm(button)
        {
            var form = document.getElementById('myForm');
            form.but.value = button.value;
            form.submit();
        }
    </script>

    <form id="myForm" action="/gamePlay" method="get">
        <div class="image">
            <img src="${Jogo.image}" alt="">
        </div>

        <div class="Textos">
            <h1 class="texto">${Jogo.texto}</h1>
        </div>

        <div>
            <button class="butt" type="button" value="${Jogo.ref1}" onclick="submitForm(this)">${Jogo.op1}</button>
        </div>

        <div>
            <button class="butt" type="button" value="${Jogo.ref2}" onclick="submitForm(this)">${Jogo.op2}</button>
        </div>

        <div>
            <button class="butt" type="button" value="${Jogo.ref3}" onclick="submitForm(this)">${Jogo.op3}</button>
        </div>
    </form>
</body>
</html>
