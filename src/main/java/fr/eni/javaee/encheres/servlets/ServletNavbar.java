package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		  if (session.getAttribute("user") == null) {
		    try {
		      session.invalidate();
		      response.sendRedirect("PageAccueil");
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  } else if (session.getAttribute("user") != null){
		    
		  }
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		}

}
