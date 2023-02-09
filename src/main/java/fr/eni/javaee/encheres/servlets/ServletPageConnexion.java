package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bll.UtilisateurManager;
import fr.eni.javaee.encheres.bo.Utilisateur;



@WebServlet("/ServletPageConnexion")
public class ServletPageConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ServletPageConnexion() {
        super();
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp");
        dispatcher.forward(request, response);
		HttpSession session = request.getSession();
		  if (session.getAttribute("utilisateur") != null) {
		    try {// fermeture de la session et redirection vers la servlet pageaccueil
		      session.invalidate();
		      response.sendRedirect("ServletPageConnexion");
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  } //else if (session.getAttribute("utilisateur") == null){
		    
		 // }
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String email = request.getParameter("email");
		String motdepasse = request.getParameter("motdepasse");

		UtilisateurManager utilisateurManager = new UtilisateurManager();

		try {
		    if (email != null && !email.isEmpty()) {
		        identifiant = email;
		      }
		    
			Utilisateur utilisateur = utilisateurManager.seconnecter(identifiant, motdepasse);

			if (utilisateur != null) {
				HttpSession session = request.getSession();
				session.setAttribute("utilisateur", utilisateur);

				response.sendRedirect("ServletPageAccueilNonConnecte");
			}


			} catch (BusinessException e) {
				e.printStackTrace();
				System.out.println("Liste code d'erreur : "+ e.getListeCodesErreur().toString());
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp");
				rd.forward(request, response);

}
}}








