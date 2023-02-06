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
import fr.eni.javaee.encheres.dal.CodesResultatDAL;
import fr.eni.javaee.encheres.dal.ConnectionProvider;
import fr.eni.javaee.encheres.dal.DAO.ArticleVenduDAO;

public class ArticleVenduJDBCImpl implements ArticleVenduDAO {
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS where no_article = ?";
	private static final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS (nomArticle, description, noCategorie,"
			+ "miseAPrix,debutEncheres, finEncheres, noUtilisateur) VALUE"
			+ "(?,?,?,?,?,?,?)";


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

	public ArticleVendu insertArticle (ArticleVendu ajoutArticle) throws BusinessException, SQLException {
		ArticleVendu nouvelArticle = null;
		if(ajoutArticle==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try(Connection cnx = ConnectionProvider.getConnection()
				;PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, PreparedStatement.RETURN_GENERATED_KEYS)){

			pstmt.setString(1, ajoutArticle.getNomArticle());
			pstmt.setString(2, ajoutArticle.getDescription());
			pstmt.setInt(3, ajoutArticle.getNoCategorie());
			pstmt.setInt(4, ajoutArticle.getMiseAPrix());
			pstmt.setDate(5,java.sql.Date.valueOf(ajoutArticle.getDebutEncheres()));
			pstmt.setDate(6,java.sql.Date.valueOf(ajoutArticle.getFinEncheres()));

			pstmt.executeUpdate();
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if(rs.next()){
					nouvelArticle = new ArticleVendu(
							ajoutArticle.getNomArticle(),
							ajoutArticle.getDescription(),
							ajoutArticle.getNoCategorie(),
							ajoutArticle.getMiseAPrix(),
							ajoutArticle.getDebutEncheres(),
							ajoutArticle.getFinEncheres()
							);
				}

			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				throw businessException;
			}
			return nouvelArticle;
		}


	}
}

