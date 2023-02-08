package fr.eni.javaee.encheres.dal.DAO;

import java.sql.SQLException;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Retrait;


public interface RetraitDAO {
	public Retrait insertAdresse(Retrait retrait, int noArticle) throws BusinessException, SQLException;
}
