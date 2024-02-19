<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 16/11/2023
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  rel="stylesheet" href="/Pages/css/indexStyles.css">
</head>
<body>

    <div class="header">
        <c:if test="${sessionScope.loggedUser != null}">
            <div class="menu">

                <h2 class="imgLogo">WMJC</h2>

                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="Pages/jsp/public/login/login.jsp">Login</a>
                <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
                <a href="/logout">Sair</a>
            </div>
        </c:if>

        <c:if test="${sessionScope.loggedUser == null}">
            <div class="menu">

                <h2 class="imgLogo">WMJC</h2>

                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="Pages/jsp/public/login/login.jsp">Login</a>
            </div>
        </c:if>
    </div>

    <div class="content">
        <span>${requestScope.message}</span>
    </div>

    <div class="footer">
        <p>WMJC 2023</p>
    </div>

</body>
</html>