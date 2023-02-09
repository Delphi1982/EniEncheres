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
      <a href="#">Enchères</a>
      <a href="ServletNouvelleVente">Vendre un article</a>
      <a href="ServletAffichantProfil">Mon profil</a>
	  <a href="ServletPageConnexion" >Se deconnecter</a>
  	</c:if>
 	<c:if test="${empty sessionScope.utilisateur}">
	  <a href="ServletPageConnexion" >S'inscrire - Se connecter</a>
  	</c:if>
	<h1 class="center">Liste des enchères</h1>
	<div class="left">
		<h2>Filtres</h2>
		<form method="post">
			<label for="search">Recherche :</label> <input type="text"
				id="search" name="search" placeholder="Le nom de l'article contient">
<!-- 			<button type="submit" name="rechercher">Rechercher</button> -->
			<a href="ServletNouvelleVente" >Rechercher</a>
			<br> <br>
		</form>
		<form>
			<label for="category">Catégorie :</label> <select id="category"
				name="category">
				<option value="" selected>Toutes les catégories</option>
				<option value="books">Livres</option>
				<option value="electronics">Electroniques</option>
				<option value="clothing">Vêtements</option>
			</select>
		</form>
		<table>
			<tr>
				<td>
					<form method="post">
						<h3>Achats/Mes ventes</h3>
						<input type="radio" id="selling1" name="option" value="encheresFull">
						<label for="selling1">enchères ouvertes</label> <br> <input
							type="radio" id="notstarted1" name="option" value="mesEncheres">
						<label for="notstarted1">mes enchères en cours</label> <br> <input
							type="radio" id="ended1" name="option" value="mesEncheresGagnees"> <label
							for="ended1">mes enchères remportées</label> <br>
						<input type="radio" id="selling2" name="option" value="mesVentesEnCours">
						<label for="selling2">mes ventes en cours</label> <br> <input
							type="radio" id="notstarted2" name="option" value="mesVentesEnAttente">
						<label for="notstarted2">ventes non débutées</label> <br> <input
							type="radio" id="ended2" name="option" value="mesVentesTerminées"> <label
							for="ended2">ventes terminées</label> <br> <br>
					</form>

				</td>
			</tr>
		</table>
	</div>
<!-- 	<div class="right"> -->
<!-- 		<input type="submit" value="Rechercher" name="recherche"> -->
<!-- 	</div> -->
</body>
</html>