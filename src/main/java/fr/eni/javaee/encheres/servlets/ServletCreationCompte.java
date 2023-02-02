package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.Constantes;
import fr.eni.javaee.encheres.bll.UtilisateurManager;
import fr.eni.javaee.encheres.bo.Utilisateur;

@WebServlet("/encheres/messages/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// affichage de la page jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageCreerCompte.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String submitButton = request.getParameter(Constantes.PARAM_SUBMIT);
	     String cancelButton = request.getParameter(Constantes.PARAM_CANCEL);
	     
	     if (cancelButton != null) { // TODO : la redirection pageAccueil depuis creer profil marche pas 
	         response.sendRedirect("/PageAccueil.jsp");
	         return;
	     }
	     
	     if (submitButton != null) {
	     String Pseudo = request.getParameter(Constantes.PARAM_PSEUDO);
	     String Prenom = request.getParameter(Constantes.PARAM_PRENOM);
	     String Telephone = request.getParameter(Constantes.PARAM_TELEPHONE);
	     int CodePostalInt = 0;
	     String CodePostal = request.getParameter(Constantes.PARAM_CODE_POSTAL);
	     try {
	         CodePostalInt = Integer.valueOf(CodePostal.trim());
	     } catch (NumberFormatException e) {
	    	 CodePostalInt=0;
	     }
	     String MotDePasse = request.getParameter(Constantes.PARAM_MOT_DE_PASSE);
	     String Nom = request.getParameter(Constantes.PARAM_NOM);
	     String Email = request.getParameter(Constantes.PARAM_EMAIL);
	     String Rue = request.getParameter(Constantes.PARAM_RUE);
	     String Ville = request.getParameter(Constantes.PARAM_VILLE);
	     int Credit = (00000);
	     // instanciation BO + BLL
	     Utilisateur newUserBO = new Utilisateur(Pseudo, Nom, Prenom, Email, Rue, CodePostalInt, Ville, MotDePasse, Credit, Telephone);
	     UtilisateurManager utilisateurManager = new UtilisateurManager();
	     try { // essai d'insertion des donnees en BDD 
	         utilisateurManager.creerCompte(newUserBO);
	     } catch (BusinessException e) {
	         request.setAttribute("listeCodeErreur", e.getListeCodesErreur());
	         request.getRequestDispatcher("/WEB-INF/jsp/PageAccueil.jsp").forward(request, response);
	     }
	  }
	}
}