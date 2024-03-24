package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Article;
import models.ArticleDaoImpl;
import models.PanierItem;

/**
 * Servlet implementation class panierServlet
 */
public class panierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public panierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<PanierItem> cartItems = (List<PanierItem>) session.getAttribute("cart");
		if (cartItems == null) {
		    cartItems = new ArrayList<PanierItem>();
		    session.setAttribute("cart", cartItems);
		}

		ArticleDaoImpl adao = new ArticleDaoImpl();
		Article articleToAdd = adao.getArticleById(Integer.parseInt(request.getParameter("articleId")));

		boolean articleExistsInCart = false;
		for (PanierItem item : cartItems) {
		    if (item.getArticle().getCodeArticle() == articleToAdd.getCodeArticle()) {
		        item.setQuantity(item.getQuantity() + 1);
		        articleExistsInCart = true;
		        break;
		    }
		}

		if (!articleExistsInCart) {
		    cartItems.add(new PanierItem(articleToAdd, 1));
		}

		int totalArticles = 0;
		for (PanierItem item : cartItems) {
		    totalArticles += item.getQuantity();
		}
		session.setAttribute("totalArticles", totalArticles);
		session.setAttribute("cart",cartItems);
        request.getRequestDispatcher("views/panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
