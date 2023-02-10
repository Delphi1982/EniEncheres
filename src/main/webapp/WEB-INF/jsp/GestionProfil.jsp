<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>


<style>
/* Styles généraux */
body {
	background-color: white;
	font-family: Arial, sans-serif;
	color: black;
	text-align: center;
}

/* Styles pour la section du logo */
.logo {
	margin: 1em 0 1em 0,5em;
}

/* Styles pour la section de formulaire */
.user-profile-form {
	display: inline-block;
	margin-top: 50px;
	text-align: left;
}

/* Styles pour les entrées de formulaire */
.form-entry {
	margin-bottom: 1em;
	text-align: left;
}

/* Styles pour les étiquettes de formulaire */
.form-label {
	font-weight: bold;
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
	<form action="ServletGestionProfil" class="user-profile-form"
		method="POST">
		<h3>Mon Profil</h3>
		<table class="form-entry">
			<tr>
				<td>
					<p>Pseudo :</p>
					<p>Email :</p>
				</td>
				<td>
				<div class="">
					<p>${utilisateur.pseudo}</p>
					<p>${utilisateur.email}</p>
					</div>
				</td>
			</tr>
		</table>
		<table class="form-entry">

			<tr>
				<td></td>
				<td>

					<p>
						<label for="Nom">Nom:</label>
					</p>
					<p>
						<input type="text" id="Nom" value="${utilisateur.nom}" name="Nom">
					</p>
					<p>
						<label for="Telephone">Téléphone:</label>
					</p>
					<p>
						<input type="text" id="Telephone" value="${utilisateur.telephone}"
							name="Telephone">
					</p>
					<p>
						<label for="CodePostal">Code postal:</label>
					</p>
					<p>
						<input type="text" id="CodePostal"
							value="${utilisateur.codePostal}" name="CodePostal">
					</p>
					<p>
						<label for="MotDePasse">Mot de passe:</label>
					</p>
					<p>
						<input type="password" id="MotDePasse"
							value="${utilisateur.motDePasse}" name="MotDePasse">
					</p>
				</td>
				<td>
					<p>
						<label for="Prenom">Prénom:</label>
					</p>
					<p>
						<input type="text" id="Prenom" value="${utilisateur.prenom}"
							name="Prenom">
					</p>
					<p>
						<label for="Rue">Rue:</label>
					</p>
					<p>
						<input type="text" id="Rue" value="${utilisateur.rue}" name="Rue">
					</p>
					<p>
						<label for="Ville">Ville:</label>
					</p>
					<p>
						<input type="text" id="Ville" value="${utilisateur.ville}"
							name="Ville">
					</p>
					<p>
						<label for="Confirmation">Confirmation:</label>
					</p>
					<p>
						<input type="password" id="Confirmation"
							value="${utilisateur.motDePasse}" name="Confirmation" required>
					</p>
				</td>
			</tr>
		</table>
		<div>
			<br>
			<c:out value="${errorMessage}" />
		</div>
		<div>
			Credits actuels :
			<c:out value="${utilisateur.credit}" />
		</div>
		<br> <br> <input type="submit" value="Enregistrer"
			name="save"> <input
			onclick="return confirm('Attention : Êtes-vous sûr de vouloir supprimer votre compte ? Cette action est irréversible et entrainera la perte de vos informations ainsi que vos credits');"
			type="submit" value="Supprimer le Compte" name="delete">
	</form>

</body>
</html>
