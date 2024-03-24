package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ClientDaoImpl implements ClientDao {

	public void addClient(Client client) throws SQLException {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        DatabaseConnection conInstance = DatabaseConnection.getInstance();
	        connection = conInstance.getConnection();

	        String email = client.getEmail();
	        statement = connection.prepareStatement("SELECT * FROM clients WHERE Email = ?");
	        statement.setString(1, email);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	        	System.out.println("yess");
	            throw new SQLException("Email already exists");
	        }
	        statement.close();
	        statement = connection.prepareStatement("INSERT INTO clients (Email, Nom, Prenom, Adresse, CodePostal, Ville, Tel, MotPasse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	        statement.setString(1, client.getEmail());
	        statement.setString(2, client.getNom());
	        statement.setString(3, client.getPrenom());
	        statement.setString(4, client.getAdresse());
	        statement.setString(5, client.getCodePostal());
	        statement.setString(6, client.getVille());
	        statement.setString(7, client.getTel());
	        statement.setString(8, client.getMotPasse());
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	    } finally {
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        if (statement != null) {
	            statement.close();
	        }
	    }
	}
	 public Client getClientByEmailAndPassword(Client c) {
	        try {
	        	 DatabaseConnection conInstance = DatabaseConnection.getInstance();
		            Connection connection = conInstance.getConnection();
	            PreparedStatement statement = connection.prepareStatement("select * from clients where Email=? and MotPasse=?");
	            statement.setString(1, c.getEmail());
	            statement.setString(2, c.getMotPasse());
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                int id = resultSet.getInt("Id");
	                String nom = resultSet.getString("Nom");
	                String email = resultSet.getString("Email");
	                String prenom = resultSet.getString("Prenom");
	                String adresse = resultSet.getString("Adresse");
	                String codePostal = resultSet.getString("CodePostal");
	                String ville = resultSet.getString("Ville");
	                String tel = resultSet.getString("Tel");
	                String  password=resultSet.getString("MotPasse");
	                Client client = new Client(id, email, nom, prenom, adresse, codePostal, ville, tel, password);
	                return client;
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
}
