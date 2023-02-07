package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bll.ArticleVenduManager;
import fr.eni.javaee.encheres.bll.BLLException;
import fr.eni.javaee.encheres.bo.ArticleVendu;
import fr.eni.javaee.encheres.bo.Retrait;
import fr.eni.javaee.encheres.bo.Utilisateur;



@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.getRequestDispatcher("/WEB-INF/jsp/PageNouvelleVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        String nomArticle = request.getParameter("nomArticle");
        String description = request.getParameter("description");
        int miseAPrix = Integer.valueOf(request.getParameter("prixInitial"));
        int noCategorie = Integer.valueOf(request.getParameter("noCategorie"));
        LocalDate debutEncheres = LocalDate.parse(request.getParameter("debutEncheres"));
        LocalDate finEncheres = LocalDate.parse(request.getParameter("finEncheres"));
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNoUtilisateur(utilisateur.getNoUtilisateur());
        ArticleVendu articleVendu = new ArticleVendu();
        articleVendu.setNomArticle(nomArticle);
        articleVendu.setDescription(description);
		articleVendu.setMiseAPrix(miseAPrix);
        articleVendu.setNoCategorie(noCategorie);
        articleVendu.setDebutEncheres(debutEncheres);
        articleVendu.setFinEncheres(finEncheres);
        // articleVendu.setNoUtilisateur(utilisateur.getNoUtilisateur());
        Retrait retrait = new Retrait();
        retrait.setRue(rue);
        retrait.setCodePostale(codePostal);
        retrait.setVille(ville);
        
        
        ArticleVenduManager articleVenduManager = new ArticleVenduManager();
        try {
			articleVenduManager.ajouterArticle(articleVendu);
		} catch (BLLException | BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect("ServletListeEncheresConnecte");
    }

	}








