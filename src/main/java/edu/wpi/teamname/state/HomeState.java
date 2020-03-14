package edu.wpi.teamname.state;

import javafx.beans.property.SimpleBooleanProperty;

public class HomeState {

  private SimpleBooleanProperty isClicked = new SimpleBooleanProperty(false);

  public boolean isClicked() {
    return this.isClicked.get();
  }

  public void setClicked(boolean b) {
    this.isClicked.set(b);
  }

  public SimpleBooleanProperty getIsClickedProp() {
    return this.isClicked;
  }
}
