package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import models.ClientDaoImpl;

/**
 * Servlet implementation class identifierServlet
 */
public class identifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public identifierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        ClientDaoImpl clientDAO = new ClientDaoImpl();
        models.Client c = new models.Client();
        c.setEmail(email);
        c.setMotPasse(password);
        models.Client foundClient=clientDAO.getClientByEmailAndPassword(c);
        if (foundClient != null) {
        	HttpSession session=request.getSession();
        	session.setAttribute("user", foundClient);
            request.getRequestDispatcher("views/acceuil.jsp").forward(request, response);

            
        } else {
            request.setAttribute("error","Mot de passe ou email incorrect");
            request.getRequestDispatcher("views/identifier.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
