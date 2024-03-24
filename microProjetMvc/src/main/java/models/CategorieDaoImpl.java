package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategorieDaoImpl implements categorieDao {
	public List<String> getAllCategory() {
        List<String> categoryNames = new ArrayList<String>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();

            String query = "SELECT Cat FROM categories";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String categoryName = resultSet.getString("Cat");
                categoryNames.add(categoryName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
        return categoryNames;
    }
	public int findCategorieIdByName(String categoryName) {
	    int categoryId = -1; 

	    try {
	        Connection connection = DatabaseConnection.getInstance().getConnection();
	        PreparedStatement statement = connection.prepareStatement("SELECT RefCat FROM categories WHERE Cat= ?");
	        statement.setString(1, categoryName);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            categoryId = resultSet.getInt("refCat");
	        }
	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return categoryId;
	}
}

