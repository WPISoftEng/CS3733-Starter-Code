package edu.wpi.teamname.modules;

import com.google.inject.AbstractModule;
import edu.wpi.teamname.services.ServiceOne;

public class ServiceOneServiceProvider extends AbstractModule {
  @Override
  protected void configure() {
    bind(ServiceOne.class).asEagerSingleton();
  }
}
