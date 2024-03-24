package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class commandeDaoImpl {
	 public int addCommande(Commande commande) {
		 int numCommande = -1;
	        try {
	            Connection connection = DatabaseConnection.getInstance().getConnection();
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO commande (CodeClient, DateCommande) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);	       
	            statement.setInt(1, commande.getCodeClient());
	            statement.setDate(2, commande.getDateCommande());
	            
	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected == 0) {
	                throw new SQLException("Creating commande failed, no rows affected.");
	            }
	            
	            ResultSet generatedKeys = statement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                numCommande = generatedKeys.getInt(1);
	                System.out.println("rrrr"+numCommande);
	            } else {
	                throw new SQLException("Creating commande failed, no ID obtained.");
	            }
	            
	            generatedKeys.close(); 
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return numCommande;
	    }
}
