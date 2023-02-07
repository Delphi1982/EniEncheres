package fr.eni.javaee.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ServletNavbar")
public class ServletNavbar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletNavbar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NavBar.jsp");
        dispatcher.forward(request, response);
		HttpSession session = request.getSession();
		  if (session.getAttribute("utilisateur") == null) {
		    try {// fermeture de la session et redirection vers la servlet pageaccueil
		      session.invalidate();
		      response.sendRedirect("pageListeEncheresConnecte");
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  } else if (session.getAttribute("utilisateur") != null){
		    
		  }
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		}

}
