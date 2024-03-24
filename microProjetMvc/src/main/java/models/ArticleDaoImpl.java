package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ArticleDaoImpl {
	public List<Article> getArticlesByCategorie(String categoryName) {
	    List<Article> articles = new ArrayList<Article>();
	    CategorieDaoImpl catdao=new CategorieDaoImpl();
	    int categoryId = catdao.findCategorieIdByName(categoryName);
	    if (categoryId == -1) {
	        return articles;
	    }
	    try {
	        Connection connection = DatabaseConnection.getInstance().getConnection();
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM articles WHERE Categorie = ?");
	        statement.setInt(1, categoryId);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int codeArticle = resultSet.getInt("CodeArticle");
	            String designation = resultSet.getString("Designation");
	            double prix = resultSet.getDouble("Prix");
	            int stock = resultSet.getInt("Stock");
	            String photo = resultSet.getString("Photo");
	            Article article = new Article(codeArticle, designation, prix, stock, categoryId, photo);
	            articles.add(article);
	        }
	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return articles;
	}
	public Article getArticleById(int articleId) {
	    Article article = null;

	    try {
	        Connection connection = DatabaseConnection.getInstance().getConnection();
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM articles WHERE CodeArticle = ?");
	        statement.setInt(1, articleId);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            String designation = resultSet.getString("Designation");
	            double prix = resultSet.getDouble("Prix");
	            int stock = resultSet.getInt("Stock");
	            int categoryId = resultSet.getInt("Categorie");
	            String photo = resultSet.getString("Photo");

	            article = new Article(articleId, designation, prix, stock, categoryId, photo);
	        }
	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return article;
	}

}
