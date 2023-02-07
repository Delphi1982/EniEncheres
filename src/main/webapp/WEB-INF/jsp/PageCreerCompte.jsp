<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>
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
		<table>
			<tr>
				<td>
					<p>
						<label for="Pseudo">Pseudo:</label><input type="text" id="Pseudo"
							name="Pseudo">
					</p>
					<p>
						<label for="Prenom">Prénom:</label><input type="text" id="Prenom"
							name="Prenom">
					</p>
					<p>
						<label for="Telephone">Téléphone:</label><input type="text"
							id="Telephone" name="Telephone">
					</p>
					<p>
						<label for="CodePostal">Code postal:</label><input type="text"
							id="CodePostal" name="CodePostal">
					</p>
					<p>
						<label for="MotDePasse">Mot de passe:</label><input
							type="password" id="MotDePasse" name="MotDePasse">
					</p>
				</td>
				<td>
					<p>
						<label for="Nom">Nom:</label><input type="text" id="Nom"
							name="Nom">
					</p>
					<p>
						<label for="Email">Email:</label><input type="email" id="Email"
							name="Email">
					</p>
					<p>
						<label for="Rue">Rue:</label><input type="text" id="Rue"
							name="Rue">
					</p>
					<p>
						<label for="Ville">Ville:</label><input type="text" id="Ville"
							name="Ville">
					</p>
					<p>
						<label for="Confirmation">Confirmation:</label><input
							type="password" id="Confirmation" name="Confirmation">
					</p>
				</td>
			</tr>
		</table>
		<div>
			<input type="submit" value="Créer" name="submit"> <input
				type="submit" value="Annuler" name="cancel"> <br> <br>
			<c:out value="${errorMessage}" />
		</div>
	</form>

</body>
</html>