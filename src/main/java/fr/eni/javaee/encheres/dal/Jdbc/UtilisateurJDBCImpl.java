package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public Utilisateur getUtilisateurByPseudo(String pseudo) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_BY_PSEUDO);)
		{
			ps.setString(1, pseudo);
			try (
					ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setCodePostal(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}	
		return utilisateur;		
	} 

	// controle du pseudo
	public int countPseudos(String pseudo) {
		int count = 0;
		
		try (PreparedStatement ps = conn.prepareStatement(
				"SELECT COUNT(*) FROM utilisateur WHERE pseudo = ?")) {
			ps.setString(1, pseudo);
			
			try (ResultSet resultSet = ps.executeQuery()) {
				if (resultSet.next()) {
					count = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
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
			ps.setString(7, user.getCodePostal());
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


	@Override // suppression en cascade de l'utilisateur et de ses informations dans les tables associées
	public void delete(int noId)throws BusinessException{
		Connection cnx = null;
		BusinessException businessException = new BusinessException();
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM UTILISATEURS WHERE idArticle = ? ON DELETE CASCADE");
			ps.setInt(1, noId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			businessException.ajouterErreur(1);
			throw businessException;
		}
		try {
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			businessException.ajouterErreur(2);
			throw businessException;
		}
	}

	@Override // maj données utilisateurs en bdd
	public void update(Utilisateur user,int noId) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE UTILISATEURS SET " + "pseudo = ?, nom = ?, prenom = ?, email = ?,"
							+ "telephone = ?, rue = ?, code_postal = ?, ville = ? mot_de_passe = ? WHERE idArticle = ?");
			ps.setString(1, user.getPseudo());
			ps.setString(2, user.getNom());
			ps.setString(3, user.getPrenom());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getRue());
			ps.setString(7, user.getCodePostal());
			ps.setString(8, user.getVille());
			ps.setString(9, user.getMotDePasse());
			ps.setInt(10, user.getCredit());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur selectbypseudo(String identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

}


