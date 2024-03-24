package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Client;
import models.Commande;
import models.LigneCommande;
import models.PanierItem;
import models.commandeDaoImpl;
import models.ligneCommandeDaoImpl;

/**
 * Servlet implementation class commandeServlet
 */
public class commandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		commandeDaoImpl comdao = new commandeDaoImpl();
	    HttpSession session = request.getSession();
	    Client cl = (Client) session.getAttribute("user");
	    System.out.println(cl.getPrenom());
	    Commande c = new Commande();
	    c.setCodeClient(cl.getId());
	    c.setDateCommande(new java.sql.Date(System.currentTimeMillis()));
	    int comId = comdao.addCommande(c);
	    System.out.println(comId+"ee");
	    ligneCommandeDaoImpl lc = new ligneCommandeDaoImpl();
	    @SuppressWarnings("unchecked")
	    List<PanierItem> cart = (ArrayList<PanierItem>) session.getAttribute("cart");
	    for (PanierItem i : cart) {
	        LigneCommande lcm = new LigneCommande();
	        lcm.setNumCommande(comId);
	        lcm.setCodeArticle(i.getArticle().getCodeArticle());
	        lcm.setQteCde(i.getQuantity());
	        lc.addLigneCommande(lcm);
	    }
	    cart.clear();
	    session.setAttribute("cart", cart);
	    List<LigneCommande> ligneCommandes = lc.getLigneCommandeByClientId(cl.getId());
	    session.setAttribute("commandes", ligneCommandes);
	    request.getRequestDispatcher("views/commande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
