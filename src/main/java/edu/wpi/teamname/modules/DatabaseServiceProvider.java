package edu.wpi.teamname.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import edu.wpi.teamname.services.DatabaseService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseServiceProvider extends AbstractModule {

  private final String realDbUrl = "jdbc:derby:myDB;create=true";
  /*
   This is a Guice Module config class. This module forces
   guice to provide an instance of the DatabaseService as a
   singleton.
  */
  @Override
  protected void configure() {
    bind(DatabaseService.class).asEagerSingleton();
  }

  @Provides
  public Connection provideConnection() throws SQLException {
    return DriverManager.getConnection(realDbUrl);
  }
}
