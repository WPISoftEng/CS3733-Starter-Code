package edu.wpi.teamname.views;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testfx.api.FxAssert.verifyThat;

import edu.wpi.teamname.services.ServiceTwo;
import edu.wpi.teamname.services.database.DatabaseService;
import edu.wpi.teamname.state.HomeState;
import java.io.IOException;
import java.io.InputStream;
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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith({MockitoExtension.class, ApplicationExtension.class})
public class HomeTest extends FxRobot {

  // Mock dependencies
  @Mock ServiceTwo two;
  @Mock DatabaseService dbService;
  @Mock FXMLLoader mockloader;
  // Don't mock since we require the state to change
  @Spy HomeState state;

  @InjectMocks HomeController controller;

  private final FXMLLoader loader = new FXMLLoader();
  private Parent sceneRoot;

  @Start
  private void start(Stage stage) throws IOException {
    loader.setControllerFactory((i) -> controller);
    sceneRoot = loader.load(getClass().getResourceAsStream("HomeView.fxml"));
    var primaryScene = new Scene(sceneRoot);
    // We are forced to inject this object afterward, since it must be created on the JavaFX thread
    controller.setAppPrimaryScene(primaryScene);

    stage.setScene(primaryScene);
    stage.setAlwaysOnTop(true);
    stage.show();
  }

  @BeforeEach
  public void init() throws IOException {
    when(mockloader.load(any(InputStream.class))).thenReturn(sceneRoot);
    when(dbService.getEmployeeName()).thenReturn("Wilson Wong");
  }

  @Test
  public void testSingleClick() {
    when(two.getResults()).thenCallRealMethod();
    clickOn("Click Me");
    verifyThat("#text", Node::isVisible);
  }

  @Test
  public void testDoubleClick() {
    when(two.getResults()).thenCallRealMethod();
    clickOn("Click Me");
    clickOn("Click Me");
    verifyThat("#text", (n) -> !n.isVisible());
  }

  @Test
  public void testGetNodes() {
    when(two.getResults())
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
