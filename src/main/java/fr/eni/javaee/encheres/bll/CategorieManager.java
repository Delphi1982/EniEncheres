package fr.eni.javaee.encheres.bll;

import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Categorie;
import fr.eni.javaee.encheres.dal.DAO.CategorieDAO;
import fr.eni.javaee.encheres.dal.Jdbc.CategorieJDBCImpl;



public class CategorieManager {
private CategorieDAO categorieDAO  = new CategorieJDBCImpl();

public CategorieManager() {

}
	
	public List<Categorie> afficherCategories() throws BusinessException {
		this.categorieDAO = new CategorieJDBCImpl();
		return categorieDAO.selectAllCategorie();
}

	public Categorie getById(int id) throws BusinessException
	{
		return categorieDAO.getById(id);
	}

	
	
}
