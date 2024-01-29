<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 28/01/2024
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC - Games</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../../css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>
    <div>
        <h1>Games</h1>

        <c:forEach var="game" items="${games}">
            <div>
                <img src="${game.bannerGamer}" alt="">
                <a href="/jogo-detalhes?id=${game.id}">${game.nameGame}</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>