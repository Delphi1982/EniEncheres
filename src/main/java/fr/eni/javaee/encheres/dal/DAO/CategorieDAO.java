package fr.eni.javaee.encheres.dal.DAO;

import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Categorie;




public interface CategorieDAO {
	List<Categorie> selectAllCategorie() throws BusinessException;

	public Categorie getById(int id) throws BusinessException;
	
}
