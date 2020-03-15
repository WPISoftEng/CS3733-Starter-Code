package edu.wpi.teamname.state;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;

@Data
public class HomeState {

  private SimpleBooleanProperty clickedProperty = new SimpleBooleanProperty(false);
  private SimpleStringProperty currentNodeProperty = new SimpleStringProperty(null);
}
