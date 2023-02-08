<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Liste des enchères</title>
</head>
<body>
	<c:if test="${not empty sessionScope.utilisateur}">
      <a href="PageEnchere.jsp">Enchères</a>
      <a href="PageVendre.jsp">Vendre un article</a>
      <a href="PageProfil.jsp">Mon profil</a>
	  <a href="ServletPageConnexion" >Se deconnecter</a>
  	</c:if>
 	<c:if test="${empty sessionScope.utilisateur}">
	  <a href="ServletPageConnexion" >S'inscrire - Se connecter</a>
  	</c:if>
	<h1 class="center">Liste des enchères</h1>
	<div class="left">
		<h2>Filtres</h2>
		<form method="post">
			<label for="search">Recherche :</label> <input type="text" id="search" name="search" placeholder="Le nom de l'article contient">
<!-- 			<button type="submit" name="rechercher">Rechercher</button> -->
			<a href="ServletNouvelleVente" >Rechercher</a>
			<br> <br>
		</form>
		<form>
			<label for="category">Catégorie :</label> <select id="category" name="category">
				<option value="" selected>Toutes les catégories</option>
				<option value="books">Livres</option>
				<option value="electronics">Electroniques</option>
				<option value="clothing">Vêtements</option>
			</select>
		</form>
	</div>
</body>
</html>