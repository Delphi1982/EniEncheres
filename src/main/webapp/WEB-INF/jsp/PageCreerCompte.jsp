<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="./css/normalize.css">
<link rel="stylesheet" href="./css/pageCreerCompte.css">

<title>ENI-enchères</title>
</head>
<body>
	<h1>ENI-enchères</h1>

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
		<div class="profil-form">
			<div class="ProfilPart1">
				<p class="input-style">
					<label for="Pseudo">Pseudo:</label><input class="case" type="text" id="Pseudo"
						name="Pseudo">
				</p>
				<p class="input-style">
					<label for="Prenom">Prénom:</label><input class="case" type="text" id="Prenom"
						name="Prenom">
				</p>
				<p class="input-style">
					<label for="Telephone">Téléphone:</label><input class="case" type="text"
						id="Telephone" name="Telephone">
				</p>
				<p class="input-style">
					<label for="CodePostal">Code postal:</label><input class="case" type="text"
						id="CodePostal" name="CodePostal">
				</p>
				<p class="input-style">
					<label for="MotDePasse">Mot de passe:</label><input class="case" type="password"
						id="MotDePasse" name="MotDePasse">
				</p>
			</div>
			
			<div class="ProfilPart2">
				<p class="input-style">
					<label for="Nom">Nom:</label><input class="case" type="text" id="Nom" name="Nom"
						>
				</p>
				<p class="input-style">
					<label for="Email">Email:</label><input class="case" type="email" id="Email"
						name="Email" >
				</p>
				<p class="input-style">
					<label for="Rue">Rue:</label><input class="case" type="text" id="Rue" name="Rue"
						>
				</p>
				<p class="input-style">
					<label for="Ville">Ville:</label><input class="case" type="text" id="Ville"
						name="Ville" >
				</p>
				<p class="input-style">
					<label for="Confirmation">Confirmation:</label><input class="case"
						type="password" id="Confirmation" name="Confirmation" >
				</p>
			</div>
		</div>
		<div >
			<input class="button1" type="submit" value="Créer" name="submit"> 
			<input class="button2" type="submit" value="Annuler" name="cancel"> <br> <br>
			<c:out value="${errorMessage}" />
		</div>
	</form>
</body>
</html>