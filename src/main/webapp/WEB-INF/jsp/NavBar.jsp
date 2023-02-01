<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <style>
    .navbar {
      display: flex;
      justify-content: space-between;
      padding: 20px;
      background-color: #333;
      color: #fff;
    }
    .navbar a {
      color: #fff;
      text-decoration: none;
      margin-right: 20px;
    }
  </style>
</head>
<body>
  <div class="navbar">
    <div>ENI-ENCHÈRES</div>
    <div>
      <a href="PageEnchere.jsp">Enchères</a>
      <a href="PageVendre.jsp">Vendre un article</a>
      <a href="PageProfil.jsp">Mon profil</a>
	  <a href="ServletNavbar" >Se deconnecter</a>
  		
		       
    </div>
  </div>
</body>
</html>