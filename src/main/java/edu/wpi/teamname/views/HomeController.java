package edu.wpi.teamname.views;

import com.google.inject.Inject;
import edu.wpi.teamname.services.ServiceOne;
import edu.wpi.teamname.services.ServiceTwo;
import edu.wpi.teamname.state.HomeState;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeController implements Initializable {

  @Inject ServiceOne db;
  @Inject ServiceTwo graph;
  @FXML private Label text;
  private HomeState state = new HomeState();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    text.visibleProperty().bind(this.state.getClickedProperty());
    text.textProperty().bind(this.state.getCurrentNodeProperty());
  }

  public void buttonClicked(ActionEvent actionEvent) {
    log.trace("{} clicked", ((Button) actionEvent.getSource()).getText());
    log.info(db.getInfoFromServiceOne());
    this.state.getClickedProperty().set(!state.getClickedProperty().get());
    this.state.getCurrentNodeProperty().set(graph.getResults().get(0));
  }
}
