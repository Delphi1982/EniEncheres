package fr.eni.javaee.encheres.dal.DAO;

import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public void insert(ArticleVendu article)throws BusinessException;
	
	public void delete(int id)throws BusinessException;

	public void update(ArticleVendu article) throws BusinessException;

	public ArticleVendu selectById(int id);

	public List<ArticleVendu> selectAll();
	
}
