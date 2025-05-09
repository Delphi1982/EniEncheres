package fr.eni.javaee.encheres.dal.DAO;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

    public void insert(Utilisateur user)throws BusinessException;

    public void delete(int id)throws BusinessException;

    public Utilisateur getUtilisateurByPseudo(String pseudo) throws BusinessException;
    
    public Utilisateur getUtilisateurByEmail(String email) throws BusinessException;

    public void update(Utilisateur user, int noId);

	public int countPseudos(String pseudo);

	public int countEmail(String pseudo);

    }