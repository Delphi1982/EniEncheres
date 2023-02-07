<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'un Article</title>
</head>
<body>
	<h1>Ajout d'un Article</h1>
	<form method="post">
		<label for="nomArticle">Nom de l'article :</label> <input
			type="text" id="nomArticle" name="nomArticle" required><br>
		<label for="description">Description :</label> <input type="text"
			id="description" name="description" required><br>
		<label for="miseAPrix">Mise à prix :</label> <input type="number"
			id="miseAPrix" name="prixInitial" required><br>
		<!--<label for="noCategorie">Catégorie :</label> <input type="number"
			id="noCategorie" name="noCategorie" required><br>-->
		<label for="debutEncheres">Début des enchères :</label> <input
			type="date" id="debutEncheres" name="debutEncheres" required><br>
		<label for="finEncheres">Fin des enchères :</label> <input type="date"
			id="finEncheres" name="finEncheres" required><br>
		<h1>Retrait</h1>
		<label for="rue">Nom de la rue :</label> <input
		type="text" id="rue" name="rue" required><br>
		<label for="codePostal">Numero code postale :</label> <input
		type="text" id="codePostal" name="codePostal" required><br>
		<label for="ville">Nom de la ville :</label> <input
		type="text" id="ville" name="ville" required><br>
		<input type="submit" value="Valider">
	</form>
</body>
</html>