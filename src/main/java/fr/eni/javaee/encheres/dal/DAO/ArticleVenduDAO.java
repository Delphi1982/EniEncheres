package fr.eni.javaee.encheres.dal.DAO;

import java.sql.SQLException;
import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public List<ArticleVendu> selectAllArticles() throws BusinessException;
	public ArticleVendu selectArticleById(int idArticle) throws BusinessException;
	public ArticleVendu insertArticle(ArticleVendu ajoutArticle) throws BusinessException, SQLException;
	}