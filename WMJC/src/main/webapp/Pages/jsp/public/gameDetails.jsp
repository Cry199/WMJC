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
    <title>Games - ${sessionScope.game.nameGame}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../../css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>

    <img src="${sessionScope.game.bannerGamer}" alt="">
    <h1>${sessionScope.game.nameGame}</h1>
    <h2>${sessionScope.game.descGame}</h2>

    <h2>Comentário</h2>
    <c:forEach var="gameComment" items="${comments}">
        <div>
            <h3>${gameComment.idUser}</h3>
            <p>${gameComment.commentGame}</p>
        </div>
    </c:forEach>

</body>
</html>
