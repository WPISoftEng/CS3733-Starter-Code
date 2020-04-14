package edu.wpi.teamname.services.database;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is a Guice Module config class. This module forces guice to provide an instance of the
 * DatabaseService as a singleton.
 */
public class DatabaseServiceProvider extends AbstractModule {

  private final String realDbUrl = "jdbc:derby:myDB;create=true";

  @Override
  protected void configure() {
    bind(DatabaseService.class).asEagerSingleton();
  }

  /**
   * Provide single connection for database access.
   *
   * @throws SQLException if connection cannot be made
   */
  @Provides
  @Singleton
  public Connection provideConnection() throws SQLException {
    return DriverManager.getConnection(realDbUrl);
  }
}
