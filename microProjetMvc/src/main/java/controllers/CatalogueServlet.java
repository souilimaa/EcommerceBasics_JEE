package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Article;
import models.ArticleDaoImpl;
import models.CategorieDaoImpl;

/**
 * Servlet implementation class CatalogueServlet
 */
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  CategorieDaoImpl c = new CategorieDaoImpl();
		    List<String> genres = c.getAllCategory();
		    request.setAttribute("genres", genres);

		    String selectedGenre = request.getParameter("genre");
		    if (selectedGenre != null) {
		        ArticleDaoImpl articleDao = new ArticleDaoImpl();
		        List<Article> articles = articleDao.getArticlesByCategorie(selectedGenre);
		        request.setAttribute("articles", articles);
		    }

		    request.getRequestDispatcher("views/catalogue.jsp").forward(request, response);
        }        
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

