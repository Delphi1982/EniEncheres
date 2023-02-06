package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bll.UtilisateurManager;
import fr.eni.javaee.encheres.bo.Utilisateur;

@WebServlet("/encheres/messages/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/PageCreerCompte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submitButton = request.getParameter("submit");
		String cancelButton = request.getParameter("cancel");

		String Pseudo = request.getParameter("Pseudo");
		String Prenom = request.getParameter("Prenom");
		String Telephone = request.getParameter("Telephone");
		String CodePostal = request.getParameter("CodePostal");
		String MotDePasse = request.getParameter("MotDePasse");
		String Nom = request.getParameter("Nom");
		String Email = request.getParameter("Email");
		String Rue = request.getParameter("Rue");
		String Ville = request.getParameter("Ville");
		int Credit = (0);

		if (cancelButton != null) { // TODO : la redirection pageAccueil depuis creer profil marche pas 
		//	response.sendRedirect("/PageAccueil.jsp");
		}

		if (submitButton != null) {
			Utilisateur newUserBO = new Utilisateur(Pseudo, Prenom, Telephone, CodePostal,MotDePasse,Nom,Email,Rue,Credit,Ville);
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			try { // essai d'insertion des donnees en BDD 
				utilisateurManager.creerCompte(newUserBO);
			} catch (BusinessException e) {
				request.setAttribute("listeCodeErreur", e.getListeCodesErreur());
				request.getRequestDispatcher("/WEB-INF/jsp/PageCreerCompte.jsp").forward(request, response);
			}
		}
	}
}