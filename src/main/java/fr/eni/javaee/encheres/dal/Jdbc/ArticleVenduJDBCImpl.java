package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.ArticleVendu;
import fr.eni.javaee.encheres.dal.CodesResultatDAL;
import fr.eni.javaee.encheres.dal.ConnectionProvider;
import fr.eni.javaee.encheres.dal.DAO.ArticleVenduDAO;

public class ArticleVenduJDBCImpl implements ArticleVenduDAO {
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS where no_article = ?";
	private static final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie)"
			+ "VALUES(?,?,?,?,?,?,?)";
	

	public List<ArticleVendu> selectAllArticles() throws BusinessException {
		List<ArticleVendu> articleVendu = new ArrayList<ArticleVendu>();

		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery(SELECT_ALL);
			while(rs.next())
			{
				articleVendu.add(new ArticleVendu( 
						rs.getString("nomArticle"),
						rs.getInt("noArticle"),
						rs.getString("description"),
						rs.getInt("noCategorie"),
						rs.getInt("miseAPrix"),
						rs.getDate("finEncheres").toLocalDate(),
						rs.getInt("noUtilisateur")
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return articleVendu;
	}

	@Override
	public ArticleVendu selectArticleById(int idArticle) throws BusinessException {
		ArticleVendu articleVendu = null;
		try(Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID)) {
			pstmt.setInt(1, idArticle);
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()){
					articleVendu = new ArticleVendu( 
							rs.getString("nom_article"),
							rs.getInt("no_article"),
							rs.getString("description"),
							rs.getInt("no_categorie"),
							rs.getInt("prix_initial"),
							rs.getDate("date_fin_encheres").toLocalDate(),
							rs.getInt("no_utilisateur")
							);
				}	} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleVendu;
	}

	public ArticleVendu insertArticle (ArticleVendu articleVendu) throws BusinessException, SQLException {
		try(Connection cnx = ConnectionProvider.getConnection()
				;PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, PreparedStatement.RETURN_GENERATED_KEYS)){

			pstmt.setString(1, articleVendu.getNomArticle());
			pstmt.setString(2, articleVendu.getDescription());
			pstmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDebutEncheres()));
			pstmt.setDate(4, java.sql.Date.valueOf(articleVendu.getFinEncheres()));
			pstmt.setInt(5, articleVendu.getMiseAPrix());
			pstmt.setInt(6, articleVendu.getCategorie().getNoCategorie());
			pstmt.setInt(7, articleVendu.getRetrait().getNoArticle());
			// pstmt.setInt(8, articleVendu.getUtilisateur().getNoUtilisateur());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if(rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));
			}
			RetraitJDBCImpl retraitJDBC = new RetraitJDBCImpl();
			retraitJDBC.insertAdresse(articleVendu.getRetrait(),articleVendu.getNoArticle());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return articleVendu;
	}


}

