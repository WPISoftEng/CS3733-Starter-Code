package edu.wpi.teamname.state;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;

@Data
public class HomeState {
  /* This stores the state of the home screen */

  private SimpleBooleanProperty clickedProperty = new SimpleBooleanProperty(false);
  private SimpleStringProperty currentNodeProperty = new SimpleStringProperty(null);

  @Override
  public String toString() {
    return super.toString();
  }
}
