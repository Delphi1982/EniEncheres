package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.encheres.bll.ArticleVenduManager;

@WebServlet("/ServletPageAccueilNonConnecte")
public class ServletPageAccueilNonConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/pageListeEncheresConnecte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recherche = request.getParameter("recherche");
		
		String barreDeRecherche = request.getParameter("barreDeRecherche");
		String categorie = request.getParameter("categorie");
		
		String choixX = request.getParameter("option");

		if (recherche != null) {
        	ArticleVenduManager encheres = new ArticleVenduManager();

		}
	}
}