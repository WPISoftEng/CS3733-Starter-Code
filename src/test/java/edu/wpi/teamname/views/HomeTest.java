package edu.wpi.teamname.views;

import static org.testfx.api.FxAssert.verifyThat;

import edu.wpi.teamname.services.DatabaseService;
import edu.wpi.teamname.services.ServiceTwo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit5.ApplicationTest;

@ExtendWith(MockitoExtension.class)
public class HomeTest extends ApplicationTest {

  @Mock ServiceTwo two;
  @Mock DatabaseService one;

  @InjectMocks HomeController controller;

  @BeforeEach
  public void init() {
    Mockito.when(one.getEmployeeName()).thenReturn("Wilson Wong");
  }

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setControllerFactory((i) -> controller);
    Parent sceneRoot = loader.load(getClass().getResourceAsStream("HomeView.fxml"));
    Scene scene = new Scene(sceneRoot);
    stage.setScene(scene);
    stage.setAlwaysOnTop(true);
    stage.show();
  }

  @Test
  public void testSingleClick() {
    Mockito.when(two.getResults()).thenCallRealMethod();
    clickOn("Click Me");
    verifyThat("#text", Node::isVisible);
  }

  @Test
  public void testDoubleClick() {
    Mockito.when(two.getResults()).thenCallRealMethod();
    clickOn("Click Me");
    clickOn("Click Me");
    verifyThat("#text", (n) -> !n.isVisible());
  }

  @Test
  public void testGetNodes() {
    Mockito.when(two.getResults())
        .thenReturn(
            new ArrayList<>() {
              {
                add("Expected");
              }
            });
    clickOn("Click Me");
    verifyThat("Expected", Node::isVisible);
  }
}
