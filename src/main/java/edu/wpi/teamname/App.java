package edu.wpi.teamname;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import edu.wpi.teamname.services.database.DatabaseService;
import edu.wpi.teamname.services.database.DatabaseServiceProvider;
import edu.wpi.teamname.state.HomeStateProvider;
import edu.wpi.teamname.views.FXMLLoaderProvider;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application {

  private FXMLLoader loader;
  private Scene primaryScene;

  @Override
  public void init() {
    log.info("Starting Up");
    primaryScene = new Scene(new AnchorPane());
    Injector injector =
        Guice.createInjector(
            new DatabaseServiceProvider(),
            new HomeStateProvider(),
            new FXMLLoaderProvider(),
            new AbstractModule() {
              @Provides
              @Singleton
              public Scene providePrimaryScene() {
                return primaryScene;
              }
            });
    var db = injector.getInstance(DatabaseService.class);
    db.initTable();
    loader = new FXMLLoader();
    loader.setControllerFactory(injector::getInstance);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = loader.load(getClass().getResourceAsStream("views/HomeView.fxml"));
    primaryScene.setRoot(root);
    primaryStage.setScene(primaryScene);
    primaryStage.setAlwaysOnTop(true);
    primaryStage.show();
  }

  @Override
  public void stop() {
    log.info("Shutting Down");
  }
}
