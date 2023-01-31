package fr.eni.javaee.encheres.dal.DAO;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;

	public interface UtilisateurDAO {

		public void insert(Utilisateur user)throws BusinessException;
		
		public void delete(int id)throws BusinessException;

		void update(Utilisateur user);
	}

