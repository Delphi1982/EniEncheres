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
		Utilisateur utilisateurPseudo = utilisateurDao.getUtilisateurByPseudo (identifiant);
		Utilisateur utilisateurEmail = utilisateurDao.getUtilisateurByEmail (identifiant);
		System.out.println("utilisateur en BDD"+ utilisateurPseudo);
		System.out.println("utilisateur en BDD"+ utilisateurEmail);
		if (utilisateurPseudo == null && utilisateurEmail == null) {
		System.out.println("utilisateur null");
			BusinessException be = new BusinessException();
		be.ajouterErreur(CodesResultatBLL.CONNEXION_KO); 
		throw be;}
		if (utilisateurPseudo != null && !utilisateurPseudo.getMotDePasse().equals(motdepasse)) {
			System.out.println("mot de passe KO" + motdepasse + " " + utilisateurPseudo.getMotDePasse());
		BusinessException be = new BusinessException();
		be.ajouterErreur(CodesResultatBLL.CONNEXION_KO); 
		throw be;}
		if (utilisateurEmail != null && !utilisateurEmail.getMotDePasse().equals(motdepasse)) {
			System.out.println("mot de passe KO" + motdepasse + " " + utilisateurEmail.getMotDePasse());
		BusinessException be = new BusinessException();
		be.ajouterErreur(CodesResultatBLL.CONNEXION_KO); 
		throw be;}
		return utilisateurPseudo != null ? utilisateurPseudo : utilisateurEmail;
	}
	
	
	

	// methode pour recuperer les infos d'un utilisateur
	public Utilisateur infosByPseudo(String pseudo) throws BusinessException{
		Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo(pseudo);
		return utilisateur;
	}
	
	public void creerCompte(Utilisateur newUser) throws BusinessException{
		//controle de la conformite des données 
		BusinessException exception = new BusinessException();
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
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		// controle champ : vide OU trop long OU different d'un alphanumerique
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
			utilisateurDAO1.update(newUser,noId);
		} catch (Exception e) {

		}
	}
}

