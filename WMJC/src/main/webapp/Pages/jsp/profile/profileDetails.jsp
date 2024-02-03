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
    <title>${sessionScope.profile.profileName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../../css/generalStyles.css">
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>

<img src="${sessionScope.profile.picProfile}" alt="" width="300px" height="500">
<h1>${sessionScope.profile.profileName}</h1>

<h2>Comentários</h2>
<c:forEach var="commentProfile" items="${comments}">
    <div>
        <img src="${commentProfile.userProfile.picProfile}" alt="" width="100px">
        <a href="/perfil-detalhes?id=${commentProfile.userProfile.idDoUser}">${commentProfile.userProfile.profileName}</a>
        <p>${commentProfile.commentProfile.comment}</p>

    </div>
</c:forEach>

</body>
</html>
