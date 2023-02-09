<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Liste des enchères</title>
  <style>

    body {
      display: flex;
      flex-direction: column;
      align-items: center;
      padding: 20px;
    }
    .header {
      display: flex;
      justify-content: space-between;
      width: 100%;
    }
    .header a {
      margin-right: 10px;
    }
    .center {
      text-align: center;
      margin-bottom: 20px;
    }
    .left {
      display: flex;
      flex-direction: column;
      align-items: center;
      width: 50%;
      margin-right: 20px;
    }
    form {
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-bottom: 20px;
    }
    label {
      margin-bottom: 10px;
    }
    input[type="text"],
    select {
      padding: 10px;
      font-size: 16px;
      width: 100%;
    }
    input[type="submit"],
    .buttoncrea a {
      padding: 10px 20px;
      background-color: black;
      color: white;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin-top: 20px;
    }
    <style>
  .navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    background-color: #f2f2f2;
  }

  .navbar a {
    color: #333;
    text-decoration: none;
    padding: 10px 20px;
    font-weight:bold;
  }

  .navbar a:hover {
    background-color: #ddd;
  }
  </style>
</head>
<body>
	<div class="logo">
		<a href="ServletPageAccueilNonConnecte"> <img
			src="./image/logo.png" alt="Eni Enchères">
		</a>
	</div>
	<div class="navbar">
		<c:if test="${not empty sessionScope.utilisateur}">
			<a href="#">Enchères</a>
			<a href="ServletNouvelleVente">Vendre un article</a>
			<a href="ServletAffichantProfil">Mon profil</a>
			<a href="ServletPageConnexion">Se deconnecter</a>
		</c:if>
		<c:if test="${empty sessionScope.utilisateur}">
			<a href="ServletPageConnexion">S'inscrire - Se connecter</a>
		</c:if>
	</div>
	<h1 class="center">Liste des enchères</h1>
	<div class="left">
			<h2>Recherche par mot-clé</h2>
		<form method="post">
			<label for="search"></label> <input type="text"
				id="search" name="search" placeholder="Le nom de l'article contient">
			<!-- 			<button type="submit" name="rechercher">Rechercher</button> -->
			<input class="button" type="submit" value="Rechercher" name="submit">  <br> <br>
		</form>
		<form>
			<c:if test="${not empty sessionScope.utilisateur}">
				<label for="category">Catégorie :</label>
				<select id="category" name="category">
					<option value="" selected>Toutes les catégories</option>
					<option value="books">Livres</option>
					<option value="electronics">Electroniques</option>
					<option value="clothing">Vêtements</option>
				</select>
			</c:if>
		</form>
		<div class="buttoncrea">
			<a href="ServletDetailsVente?idArticle=16">Détail Vente - lot n°16</a>
		</div>
	</div>
</body>
</html>