<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="fr.eni.javaee.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
</head>
<body>
<c:if test="${not empty sessionScope.utilisateur}">
 <h1>Nouvelle vente</h1>
  <section class="vente-form">
    	<% Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur"); 
    	%>
  <form action="ServletNouvelleVente" method="post">
    <p>
    <label for="Article">Article :</label>
     <input class="input" type="text" name="Article" id="Article"  placeholder="Article" required>
    </p>
    
    <p>
    <label for="Description">Description :</label>
          <textarea class="input"name="Description" id="Description" placeholder="Entrez une description de l'article"></textarea>
    </p>
    
   <div class="input-field"> <!--Un div peut être?-->
          <label for="categorie">Catégorie :</label>
          <select name="categorie" class="input" id="categorie">      
          </select>
      </div>
      
      <div class="input-field">
            <label for="DebutEnchere">Début de l'enchère :</label>
            <input class="input" type="date" name="DebutEnchere" id="DebutEnchere" required> 
        </div>
    <div class="input-field">
            <label for="FinEnchere">Fin de l'enchère :</label>
            <input class= "input" type="date" name="FinEnchere" id="FinEnchere" required> 
    </div>
    
    <div class="input-field">
              <label for="MiseAPrix">Mise à prix :</label>
              <input class="input" type="number" name="MiseAPrix" id="MiseAPrix" 
              step="1" max= "300" required>
     </div>

<!-- Retrait -->
	
      <h1>Retrait de l'objet</h1>
      <div class="input-field">
          <label for="Rue">Rue :</label>
          <input class="input" type="text" name="Rue" id="Rue" maxlength="100" required>
      </div>
    
     <div class="input-field">
          <label for="CodePostal">Code Postale :</label>
          <input class="input" type="text" name="CodePostal" id="cp" 
          step="1000" min="0" maxlength="5" required>
      </div>
  <div class="input-field">
          <label for="Ville">Ville :</label>
          <input class="input" type="text" name="Ville" id="Ville" required>
  </div>
    <!-- <p>
      <label for="utilisateur">utilisateur :</label>
      <input type="text" name="utilisateur" id="utilisateur">
    </p>-->
    <p>
      <input type="submit" value="Envoyer">
    </p>
  </form>
  </section>
  <c:if test="${not empty listeCodeErreur}">
    <ul>
      <c:forEach items="${listeCodeErreur}" var="codeErreur">
        <li>${codeErreur}</li>
      </c:forEach>
    </ul>
  </c:if>
	<!--<c:if test="${!empty listeCodeErreur}">
		<div class="alert alert-danger" role="alert">
			<strong>Erreur!</strong>
			<ul>
				<c:forEach var="code" items="${listeCodeErreur}">
					<li>${LecteurMessage.getMessageErreur(code)}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<h1>Nouvel article en vente</h1>
	<form action="ServletNouvelleVente" method="post">
		<p>Nom de l'article : <input type="text" name="Article" /></p>
		<p>Description : <textarea name="Description"></textarea></p>
		<p>Date de début d'enchère : <input type="date" name="DebutEnchere" /></p>
		<p>Date de fin d'enchère : <input type="date" name="FinEnchere" /></p>
		<p>Prix de départ : <input type="text" name="MiseAPrix" /></p>
		<p>Rue : <input type="text" name="Rue" /></p>
		<p>Code Postal : <input type="text" name="CodePostal" /></p>
		<p>Ville : <input type="text" name="Ville" /></p>
		<input type="submit" value="Enregistrer"/>
		<c:out value="${errorMessage}" />
	</form>-->
	</c:if>
	 <c:if test="${empty sessionScope.utilisateur}">
	  <a href="ServletPageConnexion" >Merci de vous inscrire avant d'ajouter un article à la vente</a>
  	</c:if>
</body>
</html>