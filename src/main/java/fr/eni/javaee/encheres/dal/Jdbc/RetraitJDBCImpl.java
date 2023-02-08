package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Retrait;
import fr.eni.javaee.encheres.dal.ConnectionProvider;
import fr.eni.javaee.encheres.dal.DAO.RetraitDAO;

public class RetraitJDBCImpl implements RetraitDAO{
	private static final String INSERT_RETRAITS = "INSERT INTO RETRAITS (rue,code_postal,ville,no_article)"
			+ "VALUES(?,?,?,?)";
	
	
	public Retrait insertAdresse (Retrait retrait, int noArticle) throws BusinessException, SQLException{
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAITS, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCodePostale());
			pstmt.setString(3, retrait.getVille());
			pstmt.setInt(4, noArticle);
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				retrait.setNoArticle(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retrait;
}}
