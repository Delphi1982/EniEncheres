<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	FELICITATIONS !!! VOUS GAGNEZ CETTE ENCHERE :) 
	un email vient de vous etre envoyé avec le détail de la commande.
			<form action="ServletEnchereGagnee" method="post">
			<div class="input-field">
			<label for="gain"></label>
				<input class="button" type="submit" value="Retour Page D'Accueil" name="submit"> 
			</div>
		</form>
</body>
</html>