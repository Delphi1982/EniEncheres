package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.encheres.bll.ArticleVenduManager;
import fr.eni.javaee.encheres.bll.EnchereManager;

@WebServlet("/ServletListeEncheresConnecte")
public class ServletListeEncheresConnecte extends HttpServlet {
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
			if (choixX != null) {
			    switch (choixX) {
			        case "encheresFull":
			            // exécuter une action pour toutes les encheres en cours
			            break;
			        case "mesEncheres":
			            // exécuter une action pour "mes enchères en cours"
			            break;
			        case "mesEncheresGagnees":
			            // exécuter une action pour "mes enchères remportées"
			            break;
			        case "mesVentesEnCours":
			            // exécuter une action pour "mes ventes en cours"
			            break;
			        case "mesVentesEnAttente":
			            // exécuter une action pour "ventes non débutées"
			            break;
			        case "mesVentesTerminées":
			            // exécuter une action pour "ventes terminées"
			            break;
			        default :
			        	
			    }
			}
		}
	}
}