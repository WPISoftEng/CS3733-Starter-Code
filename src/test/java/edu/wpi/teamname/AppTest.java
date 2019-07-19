package edu.wpi.teamname;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;

@ExtendWith(ApplicationExtension.class)
public class AppTest {

  @Test
  public void testClose(FxRobot robot) {
    robot.press(KeyCode.ALT, KeyCode.F4);
  }

  @BeforeAll
  public static void setup() throws Exception {
    FxToolkit.registerPrimaryStage();
    FxToolkit.setupApplication(App.class);
  }

  @AfterAll
  public static void cleanup() {
  }

}
