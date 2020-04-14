package edu.wpi.teamname.views;

import com.google.inject.Inject;
import edu.wpi.teamname.factories.FXMLLoaderFactory;
import edu.wpi.teamname.services.ServiceTwo;
import edu.wpi.teamname.services.database.DatabaseService;
import edu.wpi.teamname.state.HomeState;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeController implements Initializable {

  @Inject DatabaseService db;
  @Inject ServiceTwo graph;
  @Inject FXMLLoaderFactory fxmlLoaderFactory;
  @Inject HomeState state;
  @FXML private Label text;

  private Scene appPrimaryScene;

  /**
   * This method allows the tests to inject the scene at a later time, since it must be done on the
   * JavaFX thread
   *
   * @param appPrimaryScene Primary scene of the app whose root will be changed
   */
  @Inject
  public void setAppPrimaryScene(Scene appPrimaryScene) {
    this.appPrimaryScene = appPrimaryScene;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    log.debug(state.toString());
    text.visibleProperty().bind(this.state.getClickedProperty());
    text.textProperty().bind(this.state.getCurrentNodeProperty());
  }

  @FXML
  private void buttonClicked(ActionEvent actionEvent) throws IOException {
    log.trace("{} clicked", ((Button) actionEvent.getSource()).getText());
    log.info(db.getEmployeeName());
    this.state.getClickedProperty().set(!state.getClickedProperty().get());
    this.state.getCurrentNodeProperty().set(graph.getResults().get(0));
    advanceScene();
  }

  private void advanceScene() throws IOException {
    FXMLLoader loader = fxmlLoaderFactory.createInjectedFXMLLoader();
    Parent root = loader.load(getClass().getResourceAsStream("HomeView.fxml"));
    appPrimaryScene.setRoot(root);
  }
}
