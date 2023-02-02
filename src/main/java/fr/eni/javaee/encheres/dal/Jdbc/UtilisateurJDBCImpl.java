package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;
import fr.eni.javaee.encheres.dal.ConnectionProvider;
import fr.eni.javaee.encheres.dal.DAO.UtilisateurDAO;

public class UtilisateurJDBCImpl implements UtilisateurDAO {
	private static final String SELECT_BY_PSEUDO = "select no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur "
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
//A CREER !!!	businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}
		return utilisateur;
	}

	@Override
	public void delete(int noId) throws BusinessException {
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
			PreparedStatement ps = conn
					.prepareStatement("UPDATE UTILISATEURS SET " + "pseudo = ?, nom = ?, prenom = ?, email = ?,"
							+ "telephone = ?, rue = ?, code_postal = ?, ville = ?"
							+ "mot_de_passe = ?, credit = ?, administrateur = ?" + "WHERE idArticle = ?");
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
			ps.setBoolean(11, user.getAdministrateur());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Utilisateur user) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur selectbypseudo(String identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

}


