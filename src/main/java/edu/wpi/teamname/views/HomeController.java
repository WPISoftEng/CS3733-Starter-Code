package edu.wpi.teamname.views;

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

  @FXML private Label text;

  private HomeState state = new HomeState();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    text.visibleProperty().bind(this.state.getIsClickedProp());
  }

  public void buttonClicked(ActionEvent actionEvent) {
    log.trace("{} clicked", ((Button) actionEvent.getSource()).getText());
    state.setClicked(!this.state.isClicked());
  }
}
