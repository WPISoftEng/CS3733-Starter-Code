package edu.wpi.teamname.views;

import static org.testfx.api.FxAssert.verifyThat;

import edu.wpi.teamname.factories.FXMLLoaderFactory;
import edu.wpi.teamname.services.ServiceTwo;
import edu.wpi.teamname.services.database.DatabaseService;
import edu.wpi.teamname.state.HomeState;
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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith({MockitoExtension.class, ApplicationExtension.class})
public class HomeTest extends FxRobot {

  // Mock dependencies
  @Mock ServiceTwo two;
  @Mock DatabaseService one;
  @Mock FXMLLoaderFactory fxmlLoaderFactory;

  // Don't mock. Pass in real thing.
  @Spy HomeState state;

  @InjectMocks HomeController controller;
  private final FXMLLoader loader = new FXMLLoader();
  private Scene primaryScene;

  @BeforeEach
  public void init() {
    // We are forced to inject this object afterward, since it must be created on the JavaFX thread
    controller.setAppPrimaryScene(primaryScene);

    Mockito.when(one.getEmployeeName()).thenReturn("Wilson Wong");
    Mockito.when(fxmlLoaderFactory.createInjectedFXMLLoader())
        .then(
            (invocation) ->
                new FXMLLoader() {
                  {
                    setControllerFactory(i -> controller);
                  }
                });
  }

  @Start
  private void start(Stage stage) throws IOException {
    loader.setControllerFactory((i) -> controller);
    Parent sceneRoot = loader.load(getClass().getResourceAsStream("HomeView.fxml"));
    primaryScene = new Scene(sceneRoot);
    stage.setScene(primaryScene);
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
