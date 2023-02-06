package fr.eni.javaee.encheres.bll;

import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.ArticleVendu;
import fr.eni.javaee.encheres.dal.DAO.ArticleVenduDAO;
import fr.eni.javaee.encheres.dal.Jdbc.ArticleVenduJDBCImpl;



public class ArticleVenduManager {
	private ArticleVenduDAO articleVenduDAO;

	   public ArticleVendu afficherLesInformations(int idArticle) throws BusinessException {
		  this.articleVenduDAO = new ArticleVenduJDBCImpl();
	      return articleVenduDAO.selectArticleById(idArticle);
	   }
	   
	   public ArticleVendu ajouterArticle (ArticleVendu ajoutArticle)throws BLLException, BusinessException, SQLException {

		   if(ajoutArticle.getNomArticle() == null) {
			   throw new BLLException ("L'article doit avoir un nom");
		   }
		   if(ajoutArticle.getDescription() == null) {
			   throw new BLLException ("L'article doit avoir une description");
		   }
		   if(ajoutArticle.getNoCategorie() <= 0) {
			   throw new BLLException ("L'article doit avoir une categorie");
		   }
		   
		   if(ajoutArticle.getMiseAPrix() <= 0) {
			   throw new BLLException ("L'article doit avoir un prix supérieur à zéro");
		   }
		   
		   
		   if(ajoutArticle.getDebutEncheres() == null || ajoutArticle.getDebutEncheres().isAfter(LocalDate.now()) || ajoutArticle.getDebutEncheres().isBefore(LocalDate.now())){   
			   throw new BLLException ("L'article doit avoir une date de debut d'enchere et cette date doit être egal à la date du jour.");
		   }
		   
		   if(ajoutArticle.getFinEncheres() == null || ajoutArticle.getFinEncheres().isBefore(LocalDate.now())) {
			   throw new BLLException ("L'article doit avoir une date de fin d'enchere et cette date doit être supérieur à la date du jour");
		   }

		return articleVenduDAO.insertArticle(ajoutArticle);
	   }
	
	   
	}
