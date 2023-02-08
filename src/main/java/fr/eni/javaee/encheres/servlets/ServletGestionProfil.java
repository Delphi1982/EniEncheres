package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bll.UtilisateurManager;
import fr.eni.javaee.encheres.bo.Utilisateur;

@WebServlet("/ServletGestionProfil")
public class ServletGestionProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/GestionProfil.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String saveButton = request.getParameter("save");
	    String deleteButton = request.getParameter("delete"); 
	    HttpSession session = request.getSession();
        int noUtilisateur = ((Utilisateur) session.getAttribute("utilisateur")).getNoUtilisateur();
        String pseudo =  request.getParameter("pseudo");
        String nom =  request.getParameter("Nom");
        String prenom =  request.getParameter("prenom");
        String email =  request.getParameter("email");
        String rue =  request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville =  request.getParameter("ville");
        String motDePasse =  request.getParameter("motDePasse");
        String telephone =  request.getParameter("telephone");
        int credit = ((Utilisateur)session.getAttribute("utilisateur")).getCredit();
        request.setAttribute("noUtilisateur", noUtilisateur);
        request.setAttribute("pseudo", pseudo);
        request.setAttribute("nom", nom);
        request.setAttribute("prenom", prenom);
        request.setAttribute("email", email);
        request.setAttribute("rue", rue);
        request.setAttribute("codePostal", codePostal);
        request.setAttribute("ville", ville);
        request.setAttribute("motDePasse", motDePasse);
        request.setAttribute("telephone", telephone);
        request.setAttribute("credit", credit);
        UtilisateurManager utilisateurManager = new UtilisateurManager();
	    Utilisateur UserBO = new Utilisateur(pseudo,nom,prenom,email,rue,codePostal,ville,motDePasse,credit,telephone);
	     
	     if (deleteButton != null) {
	        try {
				utilisateurManager.supprimerCompte(noUtilisateur);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
	         session.invalidate();
	         response.sendRedirect("/PageAccueil.jsp");
	     }
	  
	     if (saveButton != null) {
	    	 try { 
	    		 utilisateurManager.miseAJourCompte(UserBO,noUtilisateur);
	    	 } catch (BusinessException e) {
	    	 e.printStackTrace();
	         request.setAttribute("listeCodeErreur", e.getListeCodesErreur());
	         request.getRequestDispatcher("/WEB-INF/jsp/GestionProfil.jsp").forward(request, response);
	    	 }
	     }
	     
	}
}