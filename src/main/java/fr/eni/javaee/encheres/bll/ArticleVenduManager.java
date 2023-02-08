package fr.eni.javaee.encheres.bll;

import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.ArticleVendu;
import fr.eni.javaee.encheres.dal.DAO.ArticleVenduDAO;
import fr.eni.javaee.encheres.dal.Jdbc.ArticleVenduJDBCImpl;



public class ArticleVenduManager implements ArticleVenduDAO{
	private static ArticleVenduDAO articleVenduDAO = new ArticleVenduJDBCImpl();
	private  BusinessException exception = null;
	
	   public ArticleVendu selectArticleById(int idArticle) throws BusinessException {
		  //this.articleVenduDAO = new ArticleVenduJDBCImpl();
	      return articleVenduDAO.selectArticleById(idArticle);
	   }
	   private  BusinessException getBusinessException() {
		   if (exception == null) {
			   exception = new BusinessException();
			 
		   }return exception;
	   }
	   public ArticleVendu insertArticle (ArticleVendu ajoutArticle)throws BusinessException, SQLException {
		   
		   if(ajoutArticle.getNomArticle().trim().isEmpty()) {
			   getBusinessException().ajouterErreur(CodesResultatBLL.NOM_ARTICLE);
		   }
		   if(ajoutArticle.getDescription().trim().isEmpty()) {
			   getBusinessException().ajouterErreur(CodesResultatBLL.DESCRIPTION);
		   }
		   /*if(ajoutArticle.getNoCategorie() <= 0) {
			   getBusinessException().ajouterErreur(CodesResultatBLL.NO_CATEGORIE);
			}*/
		   
		   if(ajoutArticle.getMiseAPrix() <= 0) {
			   getBusinessException().ajouterErreur(CodesResultatBLL.MISE_PRIX);
		   }
		      
		   if(ajoutArticle.getDebutEncheres() == null || ajoutArticle.getDebutEncheres().isAfter(LocalDate.now()) || ajoutArticle.getDebutEncheres().isBefore(LocalDate.now())){   
			   getBusinessException().ajouterErreur(CodesResultatBLL.DATE_ENCHERE);
		   }
		   
		   if(ajoutArticle.getFinEncheres() == null || ajoutArticle.getFinEncheres().isBefore(LocalDate.now())) {
			   getBusinessException().ajouterErreur(CodesResultatBLL.DATE_FIN_ENCHERE);
		   }
		   if (ajoutArticle.getRetrait().getRue() == null || ajoutArticle.getRetrait().getRue().trim().isEmpty()) {
			   getBusinessException().ajouterErreur(CodesResultatBLL.NOM_RUE);
			}
			
			if (ajoutArticle.getRetrait().getCodePostale() == null || ajoutArticle.getRetrait().getCodePostale().trim().isEmpty()) {
				getBusinessException().ajouterErreur(CodesResultatBLL.NOM_CODE_POSTALE);
			}
			
			if (ajoutArticle.getRetrait().getVille() == null || ajoutArticle.getRetrait().getVille().trim().isEmpty()) {
				getBusinessException().ajouterErreur(CodesResultatBLL.NOM_VILLE);
			}

		   if (exception == null || !exception.hasErreurs()) {
				articleVenduDAO.insertArticle(ajoutArticle);
			} else {
				throw exception;
			}
	   
		   return ajoutArticle;
	
	   }
	


		
	
	}
