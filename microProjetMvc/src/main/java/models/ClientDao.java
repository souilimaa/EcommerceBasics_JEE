package models;

import java.sql.SQLException;

public interface ClientDao {
void addClient(Client c)throws SQLException;
Client getClientByEmailAndPassword(Client c);
}
