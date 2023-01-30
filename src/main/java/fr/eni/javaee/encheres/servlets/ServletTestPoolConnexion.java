package fr.eni.javaee.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/modules/module4/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // créer un objet de type initialcontext
        try {
            Context context = new InitialContext();
            // Recherche de la datasource pour fournir des connexion vers la BDD
            // (l'info lookup est dans le fichier context.xml)
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            // Demande d'une connexion. La méthode getConnection met en attente
            // tant qu'aucune connexion n'est disponible dans le pool.
            Connection cnx = dataSource.getConnection();
            // Utilisation et verification si la connexion est fermée ou ouverte.
            out.print("La connexion est "+(cnx.isClosed()?"fermée":"ouverte"));
            // Libérer la connexion quand terminé
            cnx.close();//
            
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            // en cas d'erreur et pour sortir proprement je fais :
            response.setStatus((HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
            out.println("Une erreur est servenue lors de l''utilisation de la BDD" +
                    e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
