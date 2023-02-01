package fr.eni.javaee.encheres.dal.DAO;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;

	public interface UtilisateurDAO {

		public void insert(Utilisateur user)throws BusinessException;
		
		public void delete(int id)throws BusinessException;

		void update(Utilisateur user);

		public Utilisateur selectbypseudo(String identifiant);

		public Utilisateur getUtilisateurByPseudo(String no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue,
				String code_postal, String ville, String mot_de_passe, int credit) throws BusinessException;

		
	}
