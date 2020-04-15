package edu.wpi.teamname.views;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.wpi.teamname.entities.Employee;
import edu.wpi.teamname.entities.Student;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class ViewTest extends FxRobot {

  @Start
  public void start(Stage primaryStage) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("HomeView.fxml"));
    Scene scene = new Scene(loader.load());
    primaryStage.setScene(scene);
    primaryStage.setAlwaysOnTop(true);
    primaryStage.show();
  }

  @Test
  public void testTablesAppear() {
    TableView<Employee> empTable = lookup("#employeeTableView").queryTableView();
    assertEquals(3, empTable.getItems().size());

    TableView<Student> stdTable = lookup("#studentTableView").queryTableView();
    assertEquals(3, stdTable.getItems().size());
  }
}
