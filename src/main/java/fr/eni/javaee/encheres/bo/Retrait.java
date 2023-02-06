package fr.eni.javaee.encheres.bo;

public class Retrait {
	private int noArticle;
	private String rue;
	private String codePostale;
	private String ville;
	
/*private Retrait() {
	
}*/

/*private Retrait(int noArticle, String rue, String codePostale, String ville) {
	this.noArticle = noArticle;
	this.rue = rue;
	this.codePostale = codePostale;
	this.ville = ville;
}*/

public Retrait(String rue, String codePostale, String ville) {
	this.rue = rue;
	this.codePostale = codePostale;
	this.ville = ville;
}

public Retrait() {
	
}

public int getNoArticle() {
	return noArticle;
}

public void setNoArticle(int noArticle) {
	this.noArticle = noArticle;
}

public String getRue() {
	return rue;
}

public void setRue(String rue) {
	this.rue = rue;
}

public String getCodePostale() {
	return codePostale;
}

public void setCodePostale(String codePostale) {
	this.codePostale = codePostale;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) {
	this.ville = ville;
}

public String toString() {
				return "Retrait{" +
					"noArticle=" + noArticle +
					", rue=" + rue +
					", codePostale=" + codePostale +
					", ville=" + ville +
					"}";
				}
}

