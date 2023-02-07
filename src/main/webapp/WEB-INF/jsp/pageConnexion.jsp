<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage" %>

<!doctype html>
<html lang="fr">


<head>
  <meta charset="utf-8">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="./css/normalize.css">
  <link rel="stylesheet" href="./css/pageConnexion.css">

    <title>ENI-Enchères</title>
    
</head>

<body>
	<c:if test="${!empty sessionScope.identifiant &&!empty sessionScope.motdepasse}">
		<a href="ServletPageConnexion.java"></a>
	</c:if>
	
	
    <h1>ENI-Enchères</h1>
    
     	<c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
			  <strong>Erreur!</strong>
			  <ul>
			  	<c:forEach var="code" items="${listeCodesErreur}">
			  		<li>${LecteurMessage.getMessageErreur(code)}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>
    
    <form class="form-connect" method="post">
    
    	<div class="id">	
        	<label class="label-id" for="identifiant">Identifiant </label>
            <input class="input-id" type="text" name="identifiant" id="identifiant">
        </div>
       
        <div class="pw">
        <label class="label-pw" for="password">Mot de passe </label>
        <input class="input-pw" type="password" name="motdepasse" id="password">
        </div>
       
       
      
        	<div class="box-conn">
        		<input class="conn" type="submit" value="Connexion" onclick="location.href='ServletPageConnexion.java'">
        	</div>
       
        	<div class="box-rem">
        		<div class="rem-input">
        			<input type="checkbox" name="remember" id="remember"> 
        			<label for="remember">Se souvenir de moi</label>
        		</div>
        		<div class="rem-href">
        			<a href="#">Mot de passe oublié</a>
        		</div>
        	
        	</div>

			<div class="crea">
        		<input class="conn" type="submit" value="Créer compte" onclick="location.href=ServletCreationCompte.java">
        	</div>
        	
		
			
	</form>
    
</body>

</html>