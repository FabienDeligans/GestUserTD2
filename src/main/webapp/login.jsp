<%-- 
    Document   : login
    Created on : 14 févr. 2020, 21:07:41
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
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="well col-md-9">
                <h1 align='center'>Page d'identification</h1>
                <form class="form-signin form-horizontal" role="form" name="loginForm" action="login.user" method="post">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Login : </label>
                        <div class="col-md-3">
                            <input type="text" name="login" class="form-control" placeholder="Saisir votre identifiant" required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Mot de passe : </label>
                        <div class="col-md-3">
                            <input type="password" name="pwd"  class="form-control" placeholder="Saisir votre mot de passe" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4 col-md-offset-4">
                            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-log-in"></span> Valider</button>
                        </div>
                    </div>
                </form>
                <div class="col-md-6  col-md-offset-3">
                    <div class="alert-danger" role="alert">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="alert-danger" role="alert">
                                <c:if test="${erreurR != null}">
                                      <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true">${erreurR}</span>
                                </c:if>
                            </div>                                                      
                        </div>
                    </div>
                </div>				
            </div>
        </div>   

    </body>          
</html>
