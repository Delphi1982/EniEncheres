<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.eni.javaee.encheres.messages.LecteurMessage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Profil Utilisateur</title>
</head>
<body>

<h1>Profil de l'utilisateur</h1>
<table>
  <tr>
    <td>Pseudo :</td>
    <td><c:out value="${pseudo}" /></td>
  </tr>
  <tr>
    <td>Nom :</td>
    <td><c:out value="${nom}" /></td>
  </tr>
  <tr>
    <td>Prenom :</td>
    <td><c:out value="${prenom}" /></td>
  </tr>
  <tr>
    <td>Email :</td>
    <td><c:out value="${email}" /></td>
  </tr>
  <tr>
    <td>Téléphone :</td>
    <td><c:out value="${telephone}" /></td>
  </tr>
  <tr>
    <td>Rue :</td>
    <td><c:out value="${rue}" /></td>
  </tr>
  <tr>
    <td>Code Postal :</td>
    <td><c:out value="${codePostal}" /></td>
  </tr>
  <tr>
    <td>Ville :</td>
    <td><c:out value="${ville}" /></td>
  </tr>
</table>
      <br>
      <br>
<form action="ServeltAffichantProfil" method="post">
  <input type="submit" value="Modifier">
</form>

</body>
</html>