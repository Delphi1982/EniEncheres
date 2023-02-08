package fr.eni.javaee.encheres.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Categorie;
import fr.eni.javaee.encheres.dal.CodesResultatDAL;
import fr.eni.javaee.encheres.dal.ConnectionProvider;
import fr.eni.javaee.encheres.dal.DAO.CategorieDAO;

public class CategorieJDBCImpl implements CategorieDAO{
	// final String SELECT_ALL_CATEGORIE = "SELECT * FROM CATEGORIES";
	final String GET_BY_ID = "select * from CATEGORIES where no_categorie=?";
	/*
	public List<Categorie> selectAllCategorie() throws BusinessException {
		List<Categorie> listCategorie = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEGORIE);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("noCategorie"));
				categorie.setLibelle(rs.getString("libelle"));
				listCategorie.add(categorie);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return listCategorie;
	}
}	*/

public Categorie getById(int id) throws BusinessException {

	Categorie categorie = null;

	try (Connection cnx = ConnectionProvider.getConnection()) {

		PreparedStatement statement = cnx.prepareStatement(GET_BY_ID);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			categorie= new Categorie();
			categorie.setNoCategorie(rs.getInt("no_categorie"));
			categorie.setLibelle(rs.getString("libelle"));
		}}
		catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_CATEGORIES_ECHEC);
			throw businessException;
		}
		return categorie;
	}

@Override
public List<Categorie> selectAllCategorie() throws BusinessException {
	// TODO Auto-generated method stub
	return null;
}}