package edu.wpi.teamname;

import static org.testfx.api.FxAssert.verifyThat;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class Scene1Test extends ApplicationTest {

  @Override
  public void start(Stage primaryStage) throws IOException {
    App.setPrimaryStage(primaryStage);
    Parent root = FXMLLoader.load(getClass().getResource("fxml/Scene1.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Test
  public void testButton() {
    verifyThat("Scene 1", Node::isVisible);
    clickOn("Advance Scene");
    verifyThat("Scene 2", Node::isVisible);
  }
}
