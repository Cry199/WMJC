<%--
  Created by IntelliJ IDEA.
  User: caual
  Date: 28/01/2024
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>WMJC - Perfil</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../../css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>
    <h1>Perfil</h1>

    <form action="/profileComment" method="post">

        <span>${requestScope.message}</span>

        <br>

        <label for="comment">Comentários por Id</label>
        <input type="text" id="comment" name="comment">

        <br>

        <button type="submit">procurar</button>
    </form>

    <div>
        <h1>Comment</h1>
        <table>
            <tr>
                <th>comentário</th>
                <th>para: </th>
                <th>de:</th>

            </tr>
            <c:forEach var="comment" items="${comments}">
                <tr>
                    <td>${comment.comment}</td>
                    <td>${comment.idPerfil}</td>
                    <td>${comment.idUser}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
