package fr.eni.javaee.encheres.bo;


public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private String telephone;
	private String confirmation;
	private int credit;
	private Boolean administrateur;
	
	public Utilisateur() {
		super();
	}
	
	
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String rue,
			String codePostal, String ville, String motDePasse, int credit, Boolean administrateur,String telephone) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.telephone = telephone;
		this.credit = credit;
	}

	// constructeur pour creer un nouveau compte
	public Utilisateur(String pseudo,String nom,String prenom,String email,String rue,String codePostal,String ville,String motDePasse,int credit,String telephone,String Confirmation) {
		this.credit= credit;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.telephone = telephone;
		this.confirmation = Confirmation;
	}

	// constructeur affichage profil
	public Utilisateur(String pseudo, String nom, String prenom, String email, String rue, String codePostal,
			String ville, String motDePasse, int credit, String telephone) {
		this.credit= credit;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String tel) {
		this.telephone = tel;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	
	
	@Override
	public String toString() {
		return "Utilisateur: " + noUtilisateur + ", pseudo: " + pseudo + ", nom: " + nom + ", prenom: "
				+ prenom + ", email: " + email + ", rue: " + rue + ", codePostal: " + codePostal + ", ville: " + ville
				+ ", motDePasse: " + motDePasse + ", credit: " + credit + ", administrateur: " + administrateur;
	}

	public String getConfirmation() {
		return confirmation;
	}
	
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
}
