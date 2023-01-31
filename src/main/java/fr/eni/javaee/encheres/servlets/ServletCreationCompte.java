package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/encheres/messages/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// affichage de la page jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageCreerCompte.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String cancelButton = request.getParameter("cancel");
		 String submitButton = request.getParameter("submit");
		 String Pseudo = request.getParameter("Pseudo");
		 String Prenom = request.getParameter("Prenom");
		 String Telephone = request.getParameter("Telephone");
		 String CodePostal = request.getParameter("CodePostal");
		 String MotDePasse = request.getParameter("MotDePasse");
		 String Nom = request.getParameter("Nom");
		 String Email = request.getParameter("Email");
		 String Rue = request.getParameter("Rue");
		 String Ville = request.getParameter("Ville");
		 String Confirmation = request.getParameter("Confirmation");
		 	if(submitButton != null){
		 		//controle de la conformite des données et definition d'une variable erreur si pas conforme
		 			if (Pseudo.trim()==null||Prenom.trim()==null||Telephone.trim()==null||CodePostal.trim()==null||MotDePasse==null||
		 					Nom.trim()==null||Email.trim()==null||Rue.trim()==null||Ville.trim()==null||Confirmation != MotDePasse) {
				 		String errorMessage = null;
		 				errorMessage = "Tous les champs ne sont pas remplis ou sont vides. Veuillez remplir tous les champs du formulaire.";
		 				request.setAttribute("errorMessage", errorMessage);
		 				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageCreerCompte.jsp");
		 				rd.forward(request, response);
		 			}else {
		 			// valider l'insertion des données en BDD ici
		 			}
			//  sauf si bouton annuler est cliqué -> redirection
		    } else if (cancelButton != null) {
			      response.sendRedirect("NOM DE LA JSP : ACCUEIL.JSP A METTRE ICI  !!(OU URL)");
			      return;
		    }
		 }
}