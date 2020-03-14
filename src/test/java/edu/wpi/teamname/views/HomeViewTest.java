package edu.wpi.teamname.views;

import static org.testfx.api.FxAssert.verifyThat;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class HomeViewTest extends ApplicationTest {
  @Override
  public void start(Stage stage) throws IOException {
    Parent sceneRoot = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
    Scene scene = new Scene(sceneRoot);
    stage.setScene(scene);
    stage.show();
  }

  @Test
  public void testSingleClick() {
    clickOn("Click Me");
    verifyThat("#text", Node::isVisible);
  }

  @Test
  public void testDoubleClick() {
    clickOn("Click Me");
    clickOn("Click Me");
    verifyThat("#text", (n) -> !n.isVisible());
  }
}
