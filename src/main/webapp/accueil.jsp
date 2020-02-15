<%-- 
    Document   : accueil
    Created on : 14 févr. 2020, 21:33:47
    Author     : Fabien
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="well">
            <div class="text-center titre">
                <h2>Accueil</h2>
            </div>
            <div class="container">
                <h3>
                    <dl class="dl-horizontal">
                        <dt>Bienvenue</dt>
                        <dd>${userR.prenom} ${userR.nom}</dd>
                        <dt>Adresse</dt>
                        <dd>${userR.adresse}</dd>
                        <dt>Catégorie</dt>
                        <dd>
                            <select name="lstCategories" required>
                                <option value="">Sélectionner une catégorie</option>
                                <c:forEach var="categorie" items="${lstCategoriesR}">
                                    <option value="${categorie.idCategorie}" <c:if test="${categorie.idCategorie == userR.idCategorie}">SELECTED</c:if>>${categorie.libCategorie}</option>
                                </c:forEach>
                            </select>
                        </dd>
                        <dt>Profil</dt>
                        <dd><a href="modifier.user">Modifier profil</a></dd>
                    </dl>
                </h3>
            </div>
        </div>
    </body>
</html>
