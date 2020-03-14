package edu.wpi.teamname.services;

import java.sql.*;

public class DatabaseService {
  /*
   Database service class. This class will be loaded as a Singleton by Guice.
  */

  private Connection connection;

  public DatabaseService() {
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return;
    }

    // remove :memory to have persistent database
    try {
      connection = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true");
    } catch (SQLException e) {
      e.printStackTrace();
      return;
    }

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
      System.out.println("Table created");
      query = "INSERT into Employees(Name, salary, location) VALUES('Wilson Wong', 100000, 'WPI')";
      stmt.execute(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String getEmployeeName() {
    try {
      Statement stmt = connection.createStatement();
      ResultSet res = stmt.executeQuery("SELECT Name from Employees");
      if (res.next()) {
        return res.getString("Name");
      }
      return "";
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return "";
    }
  }
}
