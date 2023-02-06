package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Retrait;
import fr.eni.javaee.encheres.dal.CodesResultatDAL;
import fr.eni.javaee.encheres.dal.ConnectionProvider;
import fr.eni.javaee.encheres.dal.DAO.RetraitDAO;

public class RetraitJDBCImpl implements RetraitDAO{
	private static final String INSERT_RETRAITS = "INSERT INTO RETRAITS (rue, code_postal, ville) VALUE"
			+ "(?,?,?)";
	
	public Retrait insertAdresse (Retrait retrait) throws BusinessException, SQLException{
		Retrait nouvelAdresse = null;
	
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAITS, PreparedStatement.RETURN_GENERATED_KEYS)){

				pstmt.setString(1, retrait.getRue());
				pstmt.setString(2, retrait.getCodePostale());
				pstmt.setString(3, retrait.getVille());
				pstmt.executeUpdate();
		try (ResultSet rs = pstmt.getGeneratedKeys()) {
		if(rs.next()){
			nouvelAdresse = new Retrait(
					retrait.getRue(),
					retrait.getCodePostale(),
					retrait.getVille()
			);
		}
	}catch (Exception e) {
		e.printStackTrace();
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
		throw businessException;
	}
		return nouvelAdresse;
}}}
