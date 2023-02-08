package fr.eni.javaee.encheres.bll;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;
import fr.eni.javaee.encheres.dal.DAO.DAOFactory;
import fr.eni.javaee.encheres.dal.DAO.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDao;

	public UtilisateurManager() {
		super();
		utilisateurDao = DAOFactory .getUtilisateurDAO();
	}

	public Utilisateur seconnecter(String identifiant, String motdepasse) throws BusinessException{
		Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo (identifiant);
		if (utilisateur == null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.CONNEXION_KO); 
			throw be;}
		if (!utilisateur.getMotDePasse().equals(motdepasse)) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.CONNEXION_KO); 
			throw be;}
		return utilisateur;
	}

	public void creerCompte(Utilisateur newUser) throws BusinessException{
		//controle de la conformite des données 
		BusinessException exception = new BusinessException();
		// controle champ : vide OU trop long OU different d'un alphanumerique
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		int nbPseudos = utilisateurDAO.countPseudos(newUser.getPseudo());
		if (nbPseudos > 0) {
			exception.ajouterErreur(CodesResultatBLL.PSEUDO_KO_2);
		}
		if (newUser.getPseudo().isEmpty()  
				|| newUser.getPseudo().trim().length() > 30 
				|| !newUser.getPseudo().trim().matches("[a-z A-Z 0-9 ]+")) {
			exception.ajouterErreur(CodesResultatBLL.PSEUDO_KO);
		}
		if (newUser.getNom().trim().isEmpty()  
				|| newUser.getNom().length()>30 
				|| !newUser.getNom().matches("[a-z A-Z]+")) {
			exception.ajouterErreur(CodesResultatBLL.NOM_KO);
		}	
		if (newUser.getPrenom().trim().isEmpty() 
				|| newUser.getPrenom().length()>30 
				|| !newUser.getPrenom().matches("[a-z A-Z]+")) {
			exception.ajouterErreur(CodesResultatBLL.PRENOM_KO);
		}	
		if (newUser.getEmail().trim().isEmpty() 
				|| newUser.getEmail().length()>100) {
			exception.ajouterErreur(CodesResultatBLL.EMAIL_KO);
		}
		int nbEmail = utilisateurDAO.countEmail(newUser.getEmail());
		if (nbEmail > 0) {
			exception.ajouterErreur(CodesResultatBLL.EMAIL_KO_2);
		}
		if (newUser.getTelephone().trim().isEmpty() 
				|| newUser.getTelephone().length()>10 
				|| !newUser.getTelephone().matches("^[0-9]+$")) {
			exception.ajouterErreur(CodesResultatBLL.TELEPHONE_KO);
		}
		if (newUser.getRue().trim().isEmpty() 
				|| newUser.getRue().length()>30) {
			exception.ajouterErreur(CodesResultatBLL.RUE_KO);
		}	
		if (newUser.getCodePostal().trim().isEmpty() 
				|| newUser.getCodePostal().length()>5 
				|| !newUser.getTelephone().matches("^[0-9]+$")) {
			exception.ajouterErreur(CodesResultatBLL.CODEPOSTAL_KO);
		}
		if (newUser.getVille().trim().isEmpty() 
				|| newUser.getVille().length()>30
				|| !newUser.getVille().matches("[a-z A-Z 0-9]+")) {
			exception.ajouterErreur(CodesResultatBLL.VILLE_KO);
		} // controle champ : vide OU inferieur a 8 carac OU sans une majuscule OU sans un caractere special
		if (newUser.getMotDePasse().trim().isEmpty() 
				|| newUser.getMotDePasse().length() < 8 
				|| !newUser.getMotDePasse().matches(".*[A-Z]+.*") 
				|| !newUser.getMotDePasse().matches(".*[!@#$%^&*(),.?\":{}|<>]+.*")
				|| newUser.getConfirmation() == newUser.getMotDePasse()) {
			exception.ajouterErreur(CodesResultatBLL.MOT_DE_PASSE_KO);
		}
		if (exception.hasErreurs()) throw exception;
		// valider l'insertion des données en BDD ici (APPEL A LA DAL)
		try {
			UtilisateurDAO utilisateurDAO1 = DAOFactory.getUtilisateurDAO();
			utilisateurDAO1.insert(newUser);
		} catch (Exception e) {

		}
	}

	public void supprimerCompte(int noId) throws BusinessException {
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.delete(noId);
	}

	public void miseAJourCompte(Utilisateur newUser,int noId) throws BusinessException{
		//controle de la conformite des données 
		BusinessException exception = new BusinessException();
		// controle champ : vide OU trop long OU different d'un alphanumerique
		if (newUser.getNom().trim()==null 
				|| newUser.getNom().length()>30 
				|| !newUser.getNom().matches("[a-zA-Z0-9 ]+")) {
			exception.ajouterErreur(CodesResultatBLL.NOM_KO);
		}	
		if (newUser.getPrenom().trim()==null 
				|| newUser.getPrenom().length()>30 
				|| !newUser.getPrenom().matches("[a-zA-Z0-9]+")) {
			exception.ajouterErreur(CodesResultatBLL.PRENOM_KO);
		}	// controle champ : vide OU trop long
		if (newUser.getEmail().trim()==null 
				// TODO : CHANGER VARCHAR BDD EMAIL
				|| newUser.getEmail().length()>100) {
			exception.ajouterErreur(CodesResultatBLL.EMAIL_KO);
		}
		if (newUser.getTelephone().trim()==null 
				|| newUser.getTelephone().length()>10 
				|| !newUser.getTelephone().matches("[-+]?\\d+")) {
			exception.ajouterErreur(CodesResultatBLL.TELEPHONE_KO);
		}
		if (newUser.getRue().trim()==null 
				|| newUser.getRue().length()>30
				|| !newUser.getRue().matches("[a-zA-Z0-9 ]+")) {
			exception.ajouterErreur(CodesResultatBLL.RUE_KO);
		}	
		if (newUser.getCodePostal().trim()==null 
				|| newUser.getCodePostal().length()>5 
				|| !newUser.getCodePostal().matches("[-+]?\\d+")) {
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
			UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
			utilisateurDAO.update(newUser,noId);
		} catch (Exception e) {
		}
	}
}

