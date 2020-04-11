package edu.wpi.teamname.services;

import com.google.inject.Inject;
import java.sql.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatabaseService {
  /*
   Database service class. This class will be loaded as a Singleton by Guice.
  */

  private final Connection connection;

  @Inject
  public DatabaseService(Connection connection) {
    this.connection = connection;
  }

  public void initTable() {
    try {
      Statement stmt = connection.createStatement();
      String query =
          "CREATE TABLE Employees( "
              + "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
              + "Name VARCHAR(255), "
              + "Salary INT NOT NULL, "
              + "Location VARCHAR(255), "
              + "PRIMARY KEY (Id))";
      stmt.execute(query);
      query = "INSERT into Employees(Name, salary, location) VALUES('Wilson Wong', 100000, 'WPI')";
      stmt.execute(query);
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
  }

  public String getEmployeeName() {
    try {
      Statement stmt = connection.createStatement();
      ResultSet res = stmt.executeQuery("SELECT Name from Employees");
      if (res.next()) {
        return res.getString("Name");
      }
    } catch (SQLException throwables) {
      log.error(throwables.getMessage());
    }
    return null;
  }
}
