package fr.eni.javaee.encheres.bll;

import java.sql.SQLException;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Retrait;



public class RetraitManager {
	public Retrait insertAdresse (Retrait retrait)throws BLLException, BusinessException, SQLException {
		
		if (retrait.getRue() == null) {
			throw new BLLException ("Vous devez écrire un nom de rue");
		}
		
		if (retrait.getCodePostale() == null) {
			throw new BLLException ("Vous devez écrire un code postale");
		}
		
		if (retrait.getVille() == null) {
			throw new BLLException ("Vous devez écrire un nom de ville");
		}
		
		return retrait;
		
	}}