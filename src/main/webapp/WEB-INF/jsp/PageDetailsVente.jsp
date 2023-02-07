<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Detail Vente</title>
</head>
<body>
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
         <td><fmt:parseDate value="${articleVendu.finEncheres}" pattern="yyyy-MM-dd" var="finEncheres" type="date"/><fmt:formatDate type = "date" 
         value = "${finEncheres}" />
         </td>
         <td>${articleVendu.noUtilisateur}</td>
      </tr>
   </table>
   <input type="submit" value="Submit">
</form>

</body>
</html>