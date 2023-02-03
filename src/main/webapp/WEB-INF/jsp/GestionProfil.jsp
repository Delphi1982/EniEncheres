<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1 class="center">ENI-enchères</h1>

<h1>Profil de l'utilisateur</h1>

       	<c:if test="${!empty listeCodeErreur}">
			<div class="alert alert-danger" role="alert">
			  <strong>Erreur!</strong>
			  <ul>
			  	<c:forEach var="code" items="${listeCodeErreur}">
			  		<li>${LecteurMessage.getMessageErreur(code)}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>
 
   <form class="center" method="POST">
  <h2>Mon Profil</h2>
  <div>
    <div class="ProfilPart1">
      <p><label for="Pseudo">Pseudo:</label><input type="text" id="Pseudo" value="<c:out value="${pseudo}"/>" name="Pseudo"></p>
      <p><label for="Prenom">Prénom:</label><input type="text" id="Prenom" value="<c:out value="${prenom}"/>" name="Prenom"></p>
      <p><label for="Telephone">Téléphone:</label><input type="text" id="Telephone" value="<c:out value="${telephone}"/>" name="Telephone"></p>
      <p><label for="CodePostal">Code postal:</label><input type="text" id="CodePostal" value="<c:out value="${codePostal}"/>" name="CodePostal"></p>
      <p><label for="MotDePasse">Mot de passe:</label><input type="password" id="MotDePasse"value="<c:out value="${motDePasse}"/>" name="MotDePasse"></p>
    </div>
    <div class="ProfilPart2">
      <p><label for="Nom">Nom:</label><input type="text" id="Nom" value="<c:out value="${nom}"/>" name="Nom"></p>
      <p><label for="Email">Email:</label><input type="email" id="Email" value="<c:out value="${email}"/>" name="Email"></p>
      <p><label for="Rue">Rue:</label><input type="text" id="Rue" value="<c:out value="${rue}"/>" name="Rue"></p>
      <p><label for="Ville">Ville:</label><input type="text" id="Ville" value="<c:out value="${ville}"/>" name="Ville"></p>
      <p><label for="Confirmation">Confirmation:</label><input type="password" id="Confirmation" value="<c:out value="${confirmation}"/>" name="Confirmation" required></p>
    </div>
  </div>
  <div>
      <br>
      <c:out value ="${errorMessage}"/>
    </div>
  </form>
    <div>Credits actuels : <c:out value="${credit}" /></div>
          <br>
      <br>
<form action="ServletGestionProfil" method="post">
  <input type="submit" value="Enregistrer" name="save">
  <input onclick="return confirm('Attention : Êtes-vous sûr de vouloir supprimer votre compte ? Cette action est irréversible et entrainera la perte de vos informations ainsi que vos credits');" type="submit" value="Supprimer le Compte" name="delete">
</form>

</body>
</html>
