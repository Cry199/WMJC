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
    <link type="text/css" rel="stylesheet" href="/WEB-INF/Pages/css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>

    <div class="menu">
        <a href="index.jsp">Home</a>
        <a href="/Jogos">Jogos</a>
        <a href="Pages/jsp/login/login.jsp">Login</a>
        <a href="#"></a>
        <a href="#"></a>
        </div>
    </div>

    <span>${requestScope.message}</span>

    <div class="content">
        <h1>WELCOME TO WMJC</h1>

        <a href="WEB-INF/Pages/Jsp/public/games.jsp">
            <form action="/Jogos" method="get">
                <button class="" type="submit">Jogos</button>
            </form>
        </a>
    </div>

</body>
</html>