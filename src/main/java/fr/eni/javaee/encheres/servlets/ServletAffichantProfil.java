package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.bo.Utilisateur;

@WebServlet("/ServeltAffichantProfil")
public class ServletAffichantProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        request.setAttribute("pseudo", utilisateur.getPseudo());
        request.setAttribute("nom", utilisateur.getNom());
        request.setAttribute("prenom", utilisateur.getPrenom());
        request.setAttribute("email", utilisateur.getEmail());
        request.setAttribute("rue", utilisateur.getRue());
        request.setAttribute("codePostal", utilisateur.getCodePostal());
        request.setAttribute("ville", utilisateur.getVille());
        request.setAttribute("motDePasse", utilisateur.getMotDePasse());
        request.setAttribute("telephone", utilisateur.getTelephone());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ConsultationProfil.jsp");
        rd.forward(request, response);
	}  
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/GestionProfil.jsp");
        rd.forward(request, response);
	}

}