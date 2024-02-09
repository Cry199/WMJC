<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 28/01/2024
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC - Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../public/css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>
    <div>
        <c:if test="${sessionScope.loggedUser != null}">
            <div class="menu">
                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="#">Login</a>
                <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
                <a href="/logout">Sair</a>
            </div>
        </c:if>

        <c:if test="${sessionScope.loggedUser == null}">
            <div class="menu">
                <a href="/index">Home</a>
                <a href="/Jogos">Jogos</a>
                <a href="#">Login</a>
                <a href=""></a>
                <a href="#"></a>
            </div>
        </c:if>
    </div>

    <c:if test='${sessionScope.loggedUser.tipoUser == "admin"}'>"
        <h1>Admin</h1>
    </c:if>

</body>
</html>
