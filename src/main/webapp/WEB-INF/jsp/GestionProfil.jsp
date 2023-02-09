<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style>
.logo {
  margin-left: 3em;
  margin-top: 3em;
}
</style>

</head>
<body>
  <div class="logo">
	<a href="ServletPageAccueilNonConnecte"> <img
		src="./image/logo.png" alt="Eni Enchères">
	</a>
</div>

<h2>Profil de l'utilisateur</h2>

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
 
   <form action="ServletGestionProfil" class="center" method="POST">
  <h3>Mon Profil</h3>
  	<table>
	<tr>
	<td>
      <p>Pseudo: ${utilisateur.pseudo}</p>
      <p>Email : ${utilisateur.email}</p>
      <p><label for="Telephone">Téléphone:</label><input type="text" id="Telephone" value="${utilisateur.telephone}" name="Telephone"></p>
      <p><label for="CodePostal">Code postal:</label><input type="text" id="CodePostal" value="${utilisateur.codePostal}" name="CodePostal"></p>
      <p><label for="MotDePasse">Mot de passe:</label><input type="password" id="MotDePasse"value="${utilisateur.motDePasse}" name="MotDePasse"></p>
    </td>
	<td>
      <p><label for="Nom">Nom:</label><input type="text" id="Nom" value="${utilisateur.nom}" name="Nom"></p>
   	  <p><label for="Prenom">Prénom:</label><input type="text" id="Prenom" value="${utilisateur.prenom}" name="Prenom"></p>
      <p><label for="Rue">Rue:</label><input type="text" id="Rue" value="${utilisateur.rue}" name="Rue"></p>
      <p><label for="Ville">Ville:</label><input type="text" id="Ville" value="${utilisateur.ville}" name="Ville"></p>
      <p><label for="Confirmation">Confirmation:</label><input type="password" id="Confirmation" value="${utilisateur.motDePasse}" name="Confirmation" required></p>
    </td>
	</tr>
	</table>
  	<div>
    <br>
    <c:out value ="${errorMessage}"/>
    </div>
    <div>Credits actuels : <c:out value="${utilisateur.credit}" /></div>
    <br>
    <br>
  <input type="submit" value="Enregistrer" name="save">
  <input onclick="return confirm('Attention : Êtes-vous sûr de vouloir supprimer votre compte ? Cette action est irréversible et entrainera la perte de vos informations ainsi que vos credits');" type="submit" value="Supprimer le Compte" name="delete">
</form>

</body>
</html>
