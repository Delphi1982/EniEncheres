package fr.eni.javaee.encheres.bll;

import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Categorie;
import fr.eni.javaee.encheres.dal.DAO.CategorieDAO;
import fr.eni.javaee.encheres.dal.Jdbc.CategorieJDBCImpl;



public class CategorieManager {
private CategorieDAO listeCategorie;
	
	public List<Categorie> afficherCategories() throws BusinessException {
		this.listeCategorie = new CategorieJDBCImpl();
		return listeCategorie.selectAllCategorie();
}}
