package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bll.UtilisateurManager;
import fr.eni.javaee.encheres.bo.Utilisateur;

@WebServlet("/ServeltAffichantProfil")
public class ServletAffichantProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String otherUser = request.getParameter("otherUser");
		request.setAttribute("otherUser", otherUser);
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			Utilisateur userDifferent = utilisateurManager.infosByPseudo(otherUser);
			request.setAttribute("utilisateur", userDifferent);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/ConsultationProfil.jsp").forward(request, response);
	}  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modifyButton = request.getParameter("modify");
		if (modifyButton != null) {
			response.sendRedirect("ServletGestionProfil");
		}
	}

}