package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.ArticleVendu;
import fr.eni.javaee.encheres.dal.DAO.ArticleVenduDAO;

public class ArticleVenduJDBCImpl implements ArticleVenduDAO {
	Connection conn;
	
	@Override
	public void insert(ArticleVendu article)throws BusinessException{
	
		try {
			PreparedStatement ps = conn.prepareStatement
				("INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente"
				+ "VALUES (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, article.getNomArticle());
			ps.setString(2, article.getDescription());
			ps.setDate(3, article.getDateDebutEncheres());
			ps.setDate(4, article.getDateFinEncheres());
			ps.setInt(5, article.getMiseAPrix());
			ps.setInt(6, article.getPrixVente());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
		}
	}
	
	@Override //comment l'app recupere le noId ?
	public void delete(int noId)throws BusinessException{
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ARTICLES_VENDUS WHERE idArticle = ?");
			ps.setInt(1, noId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(ArticleVendu article)throws BusinessException{
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE ARTICLES_VENDUS SET "
					+ "nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?,"
					+ "prix_initial = ?, prix_vente = ?, WHERE idArticle = ?");
			ps.setString(1, article.getNomArticle());
			ps.setString(2, article.getDescription());
			ps.setDate(3, article.getDateDebutEncheres());
			ps.setDate(4, article.getDateFinEncheres());
			ps.setInt(5, article.getMiseAPrix());
			ps.setInt(6, article.getPrixVente());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<ArticleVendu> selectAll() {
		List<ArticleVendu> resultat = new ArrayList<ArticleVendu>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ARTICLES_VENDUS");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {  				
				int noArticle = rs.getInt("no_article"); 					
				String nomArticle = rs.getString("nom_article");				
				String description = rs.getString("description");				 
				Date dateDebutEncheres = rs.getDate("date_debut_encheres");	
				Date dateFinEncheres = rs.getDate("date_fin_encheres");			
				int miseAPrix = rs.getInt("prix_initial");					
				int prixVente = rs.getInt("prix_vente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	@Override
	public ArticleVendu selectById(int id) {
		ArticleVendu resultat = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ARTICLES_VENDUS WHERE idArticle = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) { 
				int noArticle = rs.getInt("no_article"); 					
				String nomArticle = rs.getString("nom_article");				
				String description = rs.getString("description");				 
				Date dateDebutEncheres = rs.getDate("date_debut_encheres");	
				Date dateFinEncheres = rs.getDate("date_fin_encheres");			
				int miseAPrix = rs.getInt("prix_initial");					
				int prixVente = rs.getInt("prix_vente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
}
