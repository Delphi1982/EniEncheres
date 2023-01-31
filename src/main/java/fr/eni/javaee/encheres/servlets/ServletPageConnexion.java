package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;
import fr.eni.javaee.encheres.dal.DALException;
import fr.eni.javaee.encheres.dal.DAO.UtilisateurDAO;



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
		String message = null;
		Utilisateur userCo = new Utilisateur();
		
		identifiant = request.getParameter( "identifiant" );
		motdepasse = request.getParameter( "mdp" );
		
		
		if (request.getParameter( "identifiant" ).isEmpty() ) {
			message = "Veuillez renseigner votre identifiant";
			request.setAttribute("erreur", message);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/pageConnexion.jsp" ).forward( request, response );
			return;
		}

		if (request.getParameter( "mdp" ).isEmpty()) {
			message = "Veuillez renseigner votre mot de passe.";
			request.setAttribute("erreur", message);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/pageConnexion.jsp" ).forward( request, response );
			return; 
		}

		
		
		try {
			
			if (userCo .getPseudo == identifiant && userCo .getMotdePasse == motdepasse ) {
				 HttpSession session = request.getSession();
				 String pseudo = request.getParameter("identifiant");
				 request.getSession().setAttribute("userCo", userCo);
				 getServletContext().getRequestDispatcher("lien fichier ou url").forward( request, response );
				 return; 
			}else {
				 message = "Utilisateur inconnu. Veuillez saisir un identifiant et un mot de passe existants ";
				 request.setAttribute("erreur", message);
				 getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
				 return; 
			}
		} catch (BusinessException e) {
			     request.setAttribute("erreur", e);
			     this.getServletContext().getRequestDispatcher.forward( request, response );			
		}  
		
	}
}
	

		


		


		


