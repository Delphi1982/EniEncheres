package fr.eni.javaee.encheres.bll;

import fr.eni.javaee.encheres.bo.Utilisateur;
import fr.eni.javaee.encheres.dal.DAO.DAOFactory;
import fr.eni.javaee.encheres.dal.DAO.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDao;
	
	public UtilisateurManager() {
		super();
		this.utilisateurDao = DAOFactory .getUtilisateurDAO();
	}

	public void seconnecter(String identifiant, String motdepasse) {
		Utilisateur utilisateur = utilisateurDao.selectbypseudo (identifiant);
		
	}
	


}
