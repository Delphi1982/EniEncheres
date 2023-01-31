package fr.eni.javaee.encheres.dal.DAO;

import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Categorie;




public interface CategorieDAO {
	
	public Categorie insert(Categorie categorie) throws BusinessException;
	
	public Categorie getById(int id) throws BusinessException;
	
	/*la méthode "getAll" correspond à une méthode qui récupère une liste de tous les enregistrements 
	d'une table spécifiée dans une base de données. */
	
	public List<Categorie> getAll() throws BusinessException;
	
	public void update (Categorie categorie) throws BusinessException;
	
	public void delete (int id) throws BusinessException;
}
