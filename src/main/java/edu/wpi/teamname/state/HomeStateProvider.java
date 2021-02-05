package edu.wpi.teamname.state;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import javax.inject.Singleton;

public class HomeStateProvider extends AbstractModule {

  @Provides
  @Singleton
  public HomeState provideHomeState() {
    return new HomeState();
  }
}
