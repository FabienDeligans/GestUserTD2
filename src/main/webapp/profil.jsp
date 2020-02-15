<%-- 
    Document   : profil
    Created on : 15 févr. 2020, 13:12:17
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
        <title>Profil</title>
    </head>
    <body>
        <div class="well">
            <div class="text-center titre">
                <h2><c:out value=""/></h2>
            </div>
            <form class="form-horizontal" role="form" name="employeeForm" action="enregistrer.user" method="post">

                <div class="form-group">
                    <label class="col-md-3 control-label">Nom : </label>
                    <div class="col-md-5">
                        <input type="text" name="nom" value="${userR.nom}" class="form-control" placeholder="Nom" required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Prénom : </label>
                    <div class="col-md-3">
                        <input type="text"  name="prenom" value="${userR.prenom}" class="form-control" placeholder="Prénom" required autofocus>               
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">Adresse : </label>
                    <div class="col-md-6">   
                        <input type="text" name="adresse" value="${userR.adresse}" class="form-control" placeholder="Adresse" required autofocus>
                    </div>
                </div>    
                <div class="form-group">
                    <label class="col-md-3 control-label">Login : </label>
                    <div class="col-md-2">
                        <input type="text" name="login" value="${userR.login}" class="form-control" placeholder="Login" required autofocus>
                    </div>
                </div>     
                <div class="form-group">
                    <label class="col-md-3 control-label">Mot de passe : </label>
                    <div class="col-md-2">
                        <input type="password" name="pwd" value="${userR.pwd}" class="form-control" placeholder="Mot de passe" required autofocus>
                    </div>
                </div>             

                <div class="form-group">
                    <label class="col-md-3 control-label">Catégorie : </label>
                    <div class="col-md-3">
                        <select class='form-control' name='lstCategories' required>
                            
                                <option value="">Sélectionner une catégorie</option>
                                <c:forEach var="categorie" items="${lstCategoriesR}">
                                    <option value="${categorie.idCategorie}" <c:if test="${categorie.idCategorie == userR.idCategorie}">SELECTED</c:if>>${categorie.libCategorie}</option>
                                </c:forEach>
                            
                        </select>
                    </div>
                </div>        
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-4">
                        <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span> Valider</button>
                        &nbsp;
                        <button type="button" class="btn btn-default btn-primary" onclick="window.location = 'index.user';return false;"><span class="glyphicon glyphicon-remove"></span> Annuler</button>
                    </div>           
                </div>       

            </form>
        </div>
    </body>
</html>
