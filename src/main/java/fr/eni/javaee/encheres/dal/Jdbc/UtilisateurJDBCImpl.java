package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;
import fr.eni.javaee.encheres.dal.CodesResultatDAL;
import fr.eni.javaee.encheres.dal.ConnectionProvider;
import fr.eni.javaee.encheres.dal.DAO.UtilisateurDAO;



public class UtilisateurJDBCImpl implements UtilisateurDAO {
	private static final String SELECT_BY_PSEUDO = "select no_utilisateur,pseudo,nom,prenom,email,telephone,rue,"
			+ "code_postal,ville,mot_de_passe,credit,administrateur "
			+ "from Utilisateurs where pseudo = ?;";


private Connection conn;
	
	@Override
	public void getUtilisateurByPseudo (String pseudo, String mot_de_passe) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement ps = conn.prepareStatement (SELECT_BY_PSEUDO);)
	    { 	
			ps.setString("");
		try (
			 ResultSet rs = ps.executeQuery())
		{
			if(rs.next()) 
			{
			  utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));	
				}  
			} 
			}
			 catch (SQLException e) 
		{	e.printStackTrace();
		BusinessException businessException = new BusinessException();
//A CREER !!!	businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
		throw businessException;
		}	
	return utilisateur;		
	  } 

			
 
	@Override
	public void insert(Utilisateur user) throws BusinessException {
		Connection cnx = null;
		PreparedStatement ps = null;
		BusinessException businessException = new BusinessException();
		try {
			cnx = ConnectionProvider.getConnection();
			if (user.getPseudo() == null) {
				businessException.ajouterErreur(1);
				throw businessException;
			}
			ps = cnx.prepareStatement("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getPseudo());
			ps.setString(2, user.getNom());
			ps.setString(3, user.getPrenom());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getRue());
			ps.setInt(7, user.getCodePostal());
			ps.setString(8, user.getVille());
			ps.setString(9, user.getMotDePasse());
			ps.setInt(10, user.getCredit());
			ps.setInt(11,0);

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				user.setNoUtilisateur(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			businessException.ajouterErreur(2);
			throw businessException;
		} finally {
			try {
				if (cnx != null) {
					cnx.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				businessException.ajouterErreur(3);
				throw businessException;
			}
		}
	}
	
	@Override 
	public void delete(int noId)throws BusinessException{
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM UTILISATEURS WHERE idArticle = ?");
			ps.setInt(1, noId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Utilisateur user) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE UTILISATEURS SET "
					+ "pseudo = ?, nom = ?, prenom = ?, email = ?,"
					+ "telephone = ?, rue = ?, code_postal = ?, ville = ?"
					+ "mot_de_passe = ?, credit = ?, administrateur = ?"
					+ "WHERE idArticle = ?");
			ps.setString(1, user.getPseudo());
			ps.setString(2, user.getNom());
			ps.setString(3, user.getPrenom());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getRue());
			ps.setInt(7, user.getCodePostal());
			ps.setString(8, user.getVille());
			ps.setString(9, user.getMotDePasse());
			ps.setInt(10, user.getCredit());
			ps.setString(11, user.getAdministrateur());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
