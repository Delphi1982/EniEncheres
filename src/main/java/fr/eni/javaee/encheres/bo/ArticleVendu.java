package fr.eni.javaee.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate debutEncheres;
	private LocalDate finEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;
	private int noUtilisateur;
	private int noCategorie;
	



// Constructeur Methode SELECT_ALL, SELECT_BY_ID
public ArticleVendu(String nomArticle, int noArticle, String description, 
					int noCategorie, int miseAPrix,
					LocalDate finEncheres,
					int noUtilisateur) {
	
	this.noArticle = noArticle;
	this.nomArticle = nomArticle;
	this.description = description;
	this.finEncheres = finEncheres;
	this.miseAPrix = miseAPrix;
	this.noUtilisateur = noUtilisateur;
	this.noCategorie = noCategorie;
}

// Constructeur INSERT_ARTICLES_VENDUS


public ArticleVendu(String nomArticle, String description, 
		int noCategorie, int miseAPrix,
		LocalDate debutEncheres,LocalDate finEncheres) {
	this.nomArticle = nomArticle;
	this.description = description;
	this.finEncheres = finEncheres;
	this.debutEncheres =debutEncheres;
	this.miseAPrix = miseAPrix;
	this.noCategorie = noCategorie;
}

public int getNoArticle() {
	return noArticle;
}

public void setNoArticle(int noArticle) {
	this.noArticle = noArticle;
}

public String getNomArticle() {
	return nomArticle;
}

public void setNomArticle(String nomArticle) {
	this.nomArticle = nomArticle;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public LocalDate getDebutEncheres() {
	return debutEncheres;
}

public void setDebutEncheres(LocalDate debutEncheres) {
	this.debutEncheres = debutEncheres;
}

public LocalDate getFinEncheres() {
	return finEncheres;
}

public void setFinEncheres(LocalDate finEncheres) {
	this.finEncheres = finEncheres;
}

public int getMiseAPrix() {
	return miseAPrix;
}

public void setMiseAPrix(int miseAPrix) {
	this.miseAPrix = miseAPrix;
}

public int getPrixVente() {
	return prixVente;
}

public void setPrixVente(int prixVente) {
	this.prixVente = prixVente;
}

public String getEtatVente () {
	return etatVente;
}

public void setEtatVente (String etatVente) {
	this.etatVente = etatVente;
}

public int getNoUtilisateur() {
    return noUtilisateur;
}

public void setNoUtilisateur(int noUtilisateur) {
    this.noUtilisateur = noUtilisateur;
}

public int getNoCategorie() {
    return noCategorie;
}

public void setNoCategorie(int noCategorie) {
    this.noCategorie = noCategorie;
}

public ArticleVendu() {
	super();
}

public String toString() {
	return "ArticleVendu{" +
			"noArticle=" + noArticle +
			", nomArticle=" + nomArticle +
			", description=" + description +
			", debutEncheres" + debutEncheres +
			", finEncheres=" + finEncheres +
			", miseAPrix=" + miseAPrix +
			", prixVente=" + prixVente +
			", etatVente=" + etatVente +
			"' noUtilisateur=" + noUtilisateur +
			", noCategorie=" + noCategorie +
			"}";
			
	}
}
