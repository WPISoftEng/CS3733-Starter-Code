package edu.wpi.teamname.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DatabaseServiceTest {

  private DatabaseService db = new DatabaseService();

  @Test
  public void testGetEmployeeName() {
    assertEquals("Wilson Wong", db.getEmployeeName());
  }
}
