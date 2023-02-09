<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Detail Vente</title>
<style>
* {
	text-align: center;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 20px auto;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

input[type="submit"] {
	padding: 8px 16px;
	background-color: black;
	color: white;
	border: none;
	cursor: pointer;
	margin-top: 20px;
	display: block;
	margin: 0 auto;
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
	<form action="submitArticleVendu" method="post">
		<table>
			<tr>
				<th>Nom de l'article</th>
				<th>Numéro de l'article</th>
				<th>Description</th>
				<th>Numéro de catégorie</th>
				<th>Mise à prix</th>
				<th>Fin d'enchères</th>
				<th>Numéro d'utilisateur</th>
			</tr>

			<tr>
				<td>${articleVendu.nomArticle}</td>
				<td>${articleVendu.noArticle}</td>
				<td>${articleVendu.description}</td>
				<td>${articleVendu.noCategorie}</td>
				<td>${articleVendu.miseAPrix}</td>
				<td><fmt:parseDate value="${articleVendu.finEncheres}"
						pattern="yyyy-MM-dd" var="finEncheres" type="date" /> <fmt:formatDate
						type="date" value="${finEncheres}" /></td>
				<td>${articleVendu.noUtilisateur}</td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty sessionScope.utilisateur}">
		<form action="ServletDetailsVente" method="post">
			<div class="input-field">
				<label for="enchere" style="text-align: center">Nombre de
					credits pour encherir (min. 1) : </label> <input class="input"
					type="number" name="enchere" id="enchere" step="1" max="300"
					required> <br>
				<p></p>
				<input class="button" type="submit" value="Enchérir" name="submit">
			</div>
		</form>
	</c:if>
</body>
</html>
