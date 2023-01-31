package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.bll.UtilisateurManager;
import fr.eni.javaee.encheres.bo.Utilisateur;



@WebServlet("/jsp/pageConnexion")
public class ServletPageConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public ServletPageConnexion() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String identifiant = null;
		String motdepasse = null;
		Utilisateur userCo = null;
		
		identifiant = request.getParameter( "identifiant" );
		motdepasse = request.getParameter( "mdp" );
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		utilisateurManager.seconnecter (identifiant,motdepasse);
		
		if (request.getParameter( "identifiant" ).isEmpty() ) {


			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/pageConnexion.jsp" ).forward( request, response );
			return;
		}
		if (request.getParameter( "mdp" ).isEmpty()) {
	

			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/pageConnexion.jsp" ).forward( request, response );
			return; 
		}
		if (userCo.getPseudo() == identifiant && userCo.getMotDePasse() == motdepasse ) {
			 HttpSession session = request.getSession();
			 String pseudo = request.getParameter("identifiant");
			 request.getSession().setAttribute("userCo", userCo);
			 getServletContext().getRequestDispatcher("lien fichier ou url").forward( request, response );
			 return; 
		}else {

			 getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
			 return; 
		}  
		
	}
}
	

		


		


		


