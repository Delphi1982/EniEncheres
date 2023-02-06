package fr.eni.javaee.encheres.dal.DAO;

import fr.eni.javaee.encheres.dal.Jdbc.ArticleVenduJDBCImpl;
import fr.eni.javaee.encheres.dal.Jdbc.CategorieJDBCImpl;
import fr.eni.javaee.encheres.dal.Jdbc.EnchereJDBCImpl;
import fr.eni.javaee.encheres.dal.Jdbc.RetraitJDBCImpl;
import fr.eni.javaee.encheres.dal.Jdbc.UtilisateurJDBCImpl;

public class DAOFactory {
	
	private static ArticleVenduDAO articleVenduDAO;
	private static CategorieDAO CategorieDAO;
	
		
	public static ArticleVenduDAO getArticleVenduDAO() {
        if (articleVenduDAO == null)
            articleVenduDAO = new ArticleVenduJDBCImpl();
        return articleVenduDAO;
    }
			
	public static CategorieDAO getCategorieDAO() {
	      if (CategorieDAO == null)
	        	CategorieDAO = new CategorieJDBCImpl();
	      return CategorieDAO;
	    }
		
	
	private static EnchereDAO EnchereDAO;

	public static EnchereDAO getEnchereDAO() {
	        if (EnchereDAO == null)
	        	EnchereDAO = new EnchereJDBCImpl();
	        return EnchereDAO;
	    }
		
	private static RetraitDAO RetraitDAO;

	public static RetraitDAO getRetraitDAO() {
	        if (RetraitDAO == null)
	        	RetraitDAO = new RetraitJDBCImpl();
	        return RetraitDAO;
	    }
	
	
	private static UtilisateurDAO UtilisateurDAO;

	public static UtilisateurDAO getUtilisateurDAO() {
	        if (UtilisateurDAO == null)
	        	UtilisateurDAO = new UtilisateurJDBCImpl();
	        return UtilisateurDAO;
	    }
}

