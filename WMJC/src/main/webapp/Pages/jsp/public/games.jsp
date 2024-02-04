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
    <link rel="stylesheet" href="Pages/css/gameStyles.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
</head>
<body>

<div>
    <c:if test="${sessionScope.loggedUser != null}">
        <div class="menu">
            <a href="index.jsp">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/login/login.jsp">Login</a>
            <a href="/perfil-detalhes?id=${sessionScope.loggedUser.id}">${sessionScope.loggedUser.username}</a>
            <a href="/logout">Sair</a>
        </div>
    </c:if>

    <c:if test="${sessionScope.loggedUser == null}">
        <div class="menu">
            <a href="index.jsp">Home</a>
            <a href="/Jogos">Jogos</a>
            <a href="Pages/jsp/login/login.jsp">Login</a>
            <a href=""></a>
            <a href="#"></a>
        </div>
    </c:if>
</div>
<section class="game-section">
    <h2 class="line-title">trending games</h2>
    <div class="owl-carousel custom-carousel owl-theme">
        <c:forEach var="game" items="${games}">
            <div class="item" style="background-image: url(${game.bannerGamer});">
                <div class="item-desc">
                    <h3>${game.nameGame}</h3>
                    <p>${game.descGame}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

    <script>
        jQuery(window).on('load', function(){
            jQuery(".custom-carousel").owlCarousel({
                autoWidth: true,
                loop: true
            });
            jQuery(document).ready(function () {
                jQuery(".custom-carousel .item").click(function () {
                    jQuery(".custom-carousel .item").not(jQuery(this)).removeClass("active");
                    jQuery(this).toggleClass("active");
                });
            });
        });
    </script>
</body>
</html>
