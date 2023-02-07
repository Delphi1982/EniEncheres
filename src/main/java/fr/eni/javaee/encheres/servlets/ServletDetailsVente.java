package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.encheres.BusinessException;
import fr.eni.javaee.encheres.bll.ArticleVenduManager;
import fr.eni.javaee.encheres.bo.ArticleVendu;



@WebServlet("/ServletDetailsVente")
public class ServletDetailsVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDetailsVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		int idArticle = Integer.valueOf(request.getParameter("idArticle"));
		try {
	         ArticleVendu articleVendu = articleVenduManager.afficherLesInformations(idArticle);
	         request.setAttribute("articleVendu", articleVendu);
	         
	      } catch (BusinessException e) {
	         e.printStackTrace();
	      }
	request.getRequestDispatcher("/WEB-INF/jsp/PageDetailsVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
