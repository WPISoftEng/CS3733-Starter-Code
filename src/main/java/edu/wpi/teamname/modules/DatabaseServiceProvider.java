package edu.wpi.teamname.modules;

import com.google.inject.AbstractModule;
import edu.wpi.teamname.services.DatabaseService;

public class DatabaseServiceProvider extends AbstractModule {
  /*
   This is a Guice Module config class. This module forces
   guice to provide an instance of the DatabaseService as a
   singleton.
  */
  @Override
  protected void configure() {
    bind(DatabaseService.class).asEagerSingleton();
  }
}
