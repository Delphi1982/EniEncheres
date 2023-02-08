package fr.eni.javaee.encheres.dal.DAO;

import java.sql.SQLException;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public ArticleVendu selectArticleById(int idArticle) throws BusinessException;
	public ArticleVendu insertArticle(ArticleVendu ajoutArticle) throws BusinessException, SQLException;
	}