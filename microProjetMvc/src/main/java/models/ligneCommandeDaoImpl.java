package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ligneCommandeDaoImpl {
	  public void addLigneCommande(LigneCommande ligneCommande) {
	        try {
	            Connection connection = DatabaseConnection.getInstance().getConnection();
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO `lignecommande`(`NumCommande`, `CodeArticle`, `QteCde`) VALUES (?,?,?)");
	            statement.setInt(1, ligneCommande.getNumCommande());
	            statement.setInt(2, ligneCommande.getCodeArticle());
	            statement.setInt(3, ligneCommande.getQteCde());
	            statement.executeUpdate();
	            statement.close();
	        } catch (SQLException e) {
System.out.println("here "+e);	        }
	    }
	  public List<LigneCommande> getLigneCommandeByClientId(int clientId) {
		    List<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();
		    try {
		        Connection connection = DatabaseConnection.getInstance().getConnection();
		        String query = "SELECT lc.* " +
		                       "FROM lignecommande lc " +
		                       "JOIN commande c ON lc.NumCommande = c.NumCommande " +
		                       "WHERE c.CodeClient = ?";
		        PreparedStatement statement = connection.prepareStatement(query);
		        statement.setInt(1, clientId);
		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            int numCommande = resultSet.getInt("NumCommande");
		            int codeArticle = resultSet.getInt("CodeArticle");
		            int qteCde = resultSet.getInt("QteCde");

		            LigneCommande ligneCommande = new LigneCommande(numCommande, codeArticle, qteCde);
		            lignesCommande.add(ligneCommande);
		        }

		        resultSet.close();
		        statement.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return lignesCommande;
		}
}
