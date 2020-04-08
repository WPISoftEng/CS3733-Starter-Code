package edu.wpi.teamname;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application {

  @Getter private static Stage primaryStage;

  @Override
  public void init() {
    log.info("Starting Up");
  }

  @Override
  public void start(Stage primaryStage) {
    App.primaryStage = primaryStage;
  }

  @Override
  public void stop() {
    log.info("Shutting Down");
  }
}
