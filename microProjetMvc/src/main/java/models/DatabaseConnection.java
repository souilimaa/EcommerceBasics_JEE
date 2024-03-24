package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static DatabaseConnection connectionInstance;
	private Connection connection;
private DatabaseConnection() {
	
}

public Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbName = "microprojetcommerce";
            String username = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL JDBC driver"+e);
            throw new SQLException("Error loading MySQL JDBC driver", e);
        } catch (SQLException e) {
            System.out.println("Error in connection to db");
            throw new SQLException("Error in connection to db", e);
        }
    }
    return connection;
}

//  method to close the connection
public void closeConnection() {
    if (connection != null) {
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Error closing the connection");
            e.printStackTrace(); 
        }
    }
}


public static DatabaseConnection getInstance() {
	if(connectionInstance==null) {
		synchronized(DatabaseConnection.class) {
			connectionInstance=new DatabaseConnection();
		}
	}
	return connectionInstance;
}
}
