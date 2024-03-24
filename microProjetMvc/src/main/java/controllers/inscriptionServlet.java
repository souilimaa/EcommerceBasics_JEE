package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ClientDaoImpl;

/**
 * Servlet implementation class inscriptionServlet
 */
public class inscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String adresse = request.getParameter("adresse");
	        String codePostal = request.getParameter("codePostal");
	        String ville = request.getParameter("ville");
	        String email = request.getParameter("email");
	        String motPasse = request.getParameter("MotPasse");

	        models.Client client = new  models.Client();
	        client.setNom(nom);
	        client.setPrenom(prenom);
	        client.setAdresse(adresse);
	        client.setCodePostal(codePostal);
	        client.setVille(ville);
	        client.setEmail(email);
	        client.setMotPasse(motPasse);
	        ClientDaoImpl clientDAO = new ClientDaoImpl();
	        String error = null;
	        try {
	            clientDAO.addClient(client);
	            client = clientDAO.getClientByEmailAndPassword(client);
	        } catch (Exception e) {
	            error = "Email déjà existant.";
	        }

	        if (error != null) {
	            request.setAttribute("error", error);
	            request.getRequestDispatcher("views/inscription.jsp").forward(request, response);
	        } else {
	        	HttpSession session=request.getSession();
	        	session.setAttribute("user",client);
	            request.getRequestDispatcher("views/acceuil.jsp").forward(request, response);
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
