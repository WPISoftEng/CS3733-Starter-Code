package edu.wpi.teamname.factories;

import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FXMLLoaderFactory {

  @Inject private Injector injector;

  public FXMLLoader createInjectedFXMLLoader() {
    FXMLLoader loader = new FXMLLoader();
    loader.setControllerFactory(injector::getInstance);
    return loader;
  }
}
