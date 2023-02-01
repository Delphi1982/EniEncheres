package fr.eni.javaee.encheres.bll;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;
import fr.eni.javaee.encheres.dal.DAO.DAOFactory;
import fr.eni.javaee.encheres.dal.DAO.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDao;
	
	public UtilisateurManager() {
		super();
	}

	public void seconnecter(String identifiant, String motdepasse) {
		Utilisateur utilisateur = utilisateurDao.selectbypseudo (identifiant);
	}
	
	public void creerCompte(Utilisateur newUser) throws BusinessException{
		 //controle de la conformite des données 
		 BusinessException exception = new BusinessException();
		 	// controle champ : vide OU trop long OU different d'un alphanumerique
		if (newUser.getPseudo() == null 
			|| newUser.getPseudo().trim().length() > 30 
			|| !newUser.getPseudo().trim().matches("[a-zA-Z0-9]+")) {
		exception.ajouterErreur(CodesResultatBLL.PSEUDO_KO);
	 	}	
	 	if (newUser.getNom().trim()==null 
	 		|| newUser.getNom().length()>30 
	 		|| !newUser.getNom().matches("[a-zA-Z0-9]+")) {
	 	exception.ajouterErreur(CodesResultatBLL.NOM_KO);
	 	}	
	 	if (newUser.getPrenom().trim()==null 
	 		|| newUser.getPrenom().length()>30 
	 		|| !newUser.getPrenom().matches("[a-zA-Z0-9]+")) {
	 	exception.ajouterErreur(CodesResultatBLL.PRENOM_KO);
	 	}	// controle champ : vide OU trop long
	 	if (newUser.getEmail().trim()==null 
	 		|| newUser.getEmail().length()>20) {
	 	exception.ajouterErreur(CodesResultatBLL.EMAIL_KO);
	 	}
	 	if (newUser.getTelephone().trim()==null 
	 		|| newUser.getTelephone().length()>10 
	 		|| !newUser.getTelephone().matches("[-+]?\\d+")) {
	 	exception.ajouterErreur(CodesResultatBLL.TELEPHONE_KO);
	 	}
	 	if (newUser.getRue().trim()==null 
	 		|| newUser.getRue().length()>30
	 		|| !newUser.getRue().matches("[a-zA-Z0-9]+")) {
	 	exception.ajouterErreur(CodesResultatBLL.RUE_KO);
	 	}	// controle champ : cast int en String PUIS : vide OU trop long OU different d'un entier 
	 	if (newUser.getCodePostal()<10000 
	 		|| newUser.getCodePostal()>99999){
	 	exception.ajouterErreur(CodesResultatBLL.CODEPOSTAL_KO);
	 	}
	 	if (newUser.getVille().trim()==null 
	 		|| newUser.getVille().length()>30
	 		|| !newUser.getVille().matches("[a-zA-Z0-9]+")) {
	 	exception.ajouterErreur(CodesResultatBLL.VILLE_KO);
	 	} // controle champ : vide OU inferieur a 8 carac OU sans une majuscule OU sans un caractere special
	 	if (newUser.getMotDePasse().trim()==null 
	 		|| newUser.getMotDePasse().length() < 8 
	 	    || !newUser.getMotDePasse().matches(".*[A-Z]+.*") 
	 		|| !newUser.getMotDePasse().matches(".*[!@#$%^&*(),.?\":{}|<>]+.*")) {
	 	 exception.ajouterErreur(CodesResultatBLL.MOT_DE_PASSE_KO);
	 	}
	 	
	 	if (exception.hasErreurs()) throw exception;
	 	// valider l'insertion des données en BDD ici (APPEL A LA DAL)
	 	try {
	 		DAOFactory factory = new DAOFactory();
	 		UtilisateurDAO utilisateurDAO = factory.getUtilisateurDAO();
	 		utilisateurDAO.insert(newUser);
	 	} catch (Exception e) {
	 
	 	}
	}

}
