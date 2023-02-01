package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;
import fr.eni.javaee.encheres.dal.DAO.UtilisateurDAO;
import fr.eni.javaee.encheres.dal.CodesResultatDAL;
import fr.eni.javaee.encheres.dal.ConnectionProvider;

public class UtilisateurJDBCImpl implements UtilisateurDAO {
	private static final String SELECT_BY_PSEUDO = "select no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur "
			+ "from Utilisateurs where pseudo = ?;";



	
private Connection conn;
	
	@Override
	public Utilisateur getUtilisateurByPseudo (String pseudo)throws BusinessException{
		if(user==null)
		{
			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodesResultatDAL.?);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
			 PreparedStatement pstmt;
			 ResultSet rs;
			 if(user.getPseudo()==null)
			   { 			
				 PreparedStatement ps = conn.prepareStatement
				("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) "
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
				 ps.setString(11, user.getAdministrateur());
			 
				 ps.executeUpdate();
				 ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) 
			{
				user.setNoUtilisateur(rs.getInt(1));
			}
			rs.close();
			ps.close();
			} 
			}
			 catch (SQLException e) 
		
		{	e.printStackTrace();
			cnx.rollback();
			throw e;
		}	
			
	  } finally 
			
	
	
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

	@Override
	public Utilisateur selectbypseudo(String identifiant) {
		Utilisateur utilisateur = null;
		
		return utilisateur;
	}
	
	
	
}