package edu.wpi.teamname;

import edu.wpi.teamname.view.GridViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application {

  @Override
  public void init() {
    log.info("Starting Up");
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    Scene primaryScene = new Scene(new AnchorPane());
    FXMLLoader loader = new FXMLLoader();
    loader.setControllerFactory(GridViewController -> new GridViewController(primaryScene));
    primaryScene.setRoot(loader.load(getClass().getResourceAsStream("view/GridView.fxml")));
    primaryStage.setScene(primaryScene);
    primaryStage.show();
  }

  @Override
  public void stop() {
    log.info("Shutting Down");
  }
}
