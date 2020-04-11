package edu.wpi.teamname.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseServiceTest {

  private static final String jdbcUrl = "jdbc:derby:memory:myDb;create=true";
  private static final String closeUrl = "jdbc:derby:memory:myDb;drop=true";
  private Connection conn;
  private DatabaseService db;

  @BeforeEach
  public void init() throws SQLException {
    conn = DriverManager.getConnection(jdbcUrl);
    db = new DatabaseService(conn);
  }

  @AfterEach
  public void teardown() {
    try {
      conn.close();
      DriverManager.getConnection(closeUrl);
    } catch (SQLException ignored) {
    }
  }

  @Test
  public void testGetEmployeeName() {
    db.initTable();
    assertEquals("Wilson Wong", db.getEmployeeName());
  }

  @Test
  public void testGetEmployeeNameNoResults() throws SQLException {
    assertNull(db.getEmployeeName());

    conn.createStatement().execute("Create Table Employees(Name varchar(25))");
    assertNull(db.getEmployeeName());
  }
}
