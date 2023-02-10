<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil Utilisateur</title>
<style>
.logo {
	margin: 1em 0 1em 0,5em;
}
body {
	background-color: white;
	font-family: Arial, sans-serif;
	color: black;
	text-align: center;
	margin: 0 auto;
    width: 50%;
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

<table class="body" style="margin: 0 auto">
  <tr>
    <td>Pseudo :</td>
    <td><c:out value="${utilisateur.pseudo}" /></td>
  </tr>
  <tr>
    <td>Nom :</td>
    <td><c:out value="${utilisateur.nom}" /></td>
  </tr>
  <tr>
    <td>Prenom :</td>
    <td><c:out value="${utilisateur.prenom}" /></td>
  </tr>
  <tr>
    <td>Email :</td>
    <td><c:out value="${utilisateur.email}" /></td>
  </tr>
  <tr>
    <td>Téléphone :</td>
    <td><c:out value="${utilisateur.telephone}" /></td>
  </tr>
  <tr>
    <td>Rue :</td>
    <td><c:out value="${utilisateur.rue}" /></td>
  </tr>
  <tr>
    <td>Code Postal :</td>
    <td><c:out value="${utilisateur.codePostal}" /></td>
  </tr>
  <tr>
    <td>Ville :</td>
    <td><c:out value="${utilisateur.ville}" /></td>
  </tr>
</table>

      <br>
      <br>
<c:if test="${not empty sessionScope.utilisateur}">
<form action="ServletAffichantProfil" method="post">
  <input type="submit" value="Modifier" name="modify">
</form>
</c:if>

</body>
</html>