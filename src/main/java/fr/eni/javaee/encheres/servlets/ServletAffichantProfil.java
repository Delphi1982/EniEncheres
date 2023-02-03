package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServeletAffichantProfil
 */
@WebServlet("/ServeltAffichantProfil")
public class ServletAffichantProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se connecter à la base de données
        // Récupérer les informations de session de l'utilisateur connecté
        HttpSession session = request.getSession();
        int noUtilisateur = (int) session.getAttribute("noUtilisateur");
        String pseudo = (String) session.getAttribute("pseudo");
        String nom = (String) session.getAttribute("nom");
        String prenom = (String) session.getAttribute("prenom");
        String email = (String) session.getAttribute("email");
        String rue = (String) session.getAttribute("rue");
        String codePostal = (String) session.getAttribute("codePostal");
        String ville = (String) session.getAttribute("ville");
        String motDePasse = (String) session.getAttribute("motDePasse");
        String telephone = (String) session.getAttribute("telephone");
        int credit = (int) session.getAttribute("credit");
        // Stocker les informations dans les variables de requête
        request.setAttribute("pseudo", pseudo);
        request.setAttribute("nom", nom);
        request.setAttribute("prenom", prenom);
        request.setAttribute("email", email);
        request.setAttribute("rue", rue);
        request.setAttribute("codePostal", codePostal);
        request.setAttribute("ville", ville);
        request.setAttribute("motDePasse", motDePasse);
        request.setAttribute("telephone", telephone);
        // Transferer l'affichage a la JSP
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ConsultationProfil.jsp");
        rd.forward(request, response);
	}  
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/GestionProfil.jsp");
        rd.forward(request, response);
	}

}