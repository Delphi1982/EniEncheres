package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bll.ArticleVenduManager;
import fr.eni.javaee.encheres.bll.CategorieManager;
import fr.eni.javaee.encheres.bo.ArticleVendu;
import fr.eni.javaee.encheres.bo.Categorie;
import fr.eni.javaee.encheres.bo.Retrait;
import fr.eni.javaee.encheres.bo.Utilisateur;






@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.getRequestDispatcher("/WEB-INF/jsp/PageNouvelleVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArticleVendu article = new ArticleVendu();
		
		try {
			String nom = request.getParameter("Article");
			String description = request.getParameter("Description");
			LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("DebutEnchere"));
			LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("FinEnchere"));
			int miseAPrix = Integer.parseInt(request.getParameter("MiseAPrix"));
			String rue = request.getParameter("Rue");
			String codePostal = request.getParameter("CodePostal");
			String ville = request.getParameter("Ville");
			
			Categorie categorie = new Categorie();
			article.setCategorie(categorie);
			
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			article.setUtilisateur(utilisateur);
			Retrait retrait = new Retrait();
				
			retrait = new Retrait();
			retrait.setRue(rue);
			retrait.setCodePostale(codePostal);
			retrait.setVille(ville);
				
			article.setRetrait(retrait);			
			
			article.setNomArticle(nom);
			article.setDescription(description);
			article.setDebutEncheres(dateDebutEncheres);
			article.setFinEncheres(dateFinEncheres);
			article.setMiseAPrix(miseAPrix);
			article.setCategorie(categorie);
			
			ArticleVenduManager articleVenduManager = new ArticleVenduManager();
			
			articleVenduManager.insertArticle(article);
			response.sendRedirect("ServletPageAccueilNonConnecte");
			} catch (BusinessException e) {
			   request.setAttribute("listeCodeErreur", e.getListeCodesErreur());
			   this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/PageNouvelleVente.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}}
			










