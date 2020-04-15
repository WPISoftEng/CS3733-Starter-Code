package edu.wpi.teamname.views;

import edu.wpi.teamname.entities.Employee;
import edu.wpi.teamname.entities.Student;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable {

  @FXML private TableView<Employee> employeeTableView;
  @FXML private TableView<Student> studentTableView;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
    firstNameCol.setCellValueFactory(param -> param.getValue().getFirstName());
    TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
    lastNameCol.setCellValueFactory(param -> param.getValue().getLastName());
    TableColumn<Employee, String> idCol = new TableColumn<>("Id");
    idCol.setCellValueFactory(param -> param.getValue().getId());
    TableColumn<Employee, Number> ageCol = new TableColumn<>("Age");
    ageCol.setCellValueFactory(param -> param.getValue().getAge());

    employeeTableView.getColumns().addAll(firstNameCol, lastNameCol, idCol, ageCol);
    ArrayList<Employee> employeeArrayList =
        new ArrayList<>() {
          {
            add(new Employee("first1", "last1", "id1", 10));
            add(new Employee("first2", "last2", "id2", 11));
            add(new Employee("first3", "last3", "id3", 12));
          }
        };
    employeeTableView.getItems().setAll(employeeArrayList);

    TableColumn<Student, String> sfirstNameCol = new TableColumn<>("First Name");
    sfirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    TableColumn<Student, String> slastNameCol = new TableColumn<>("Last Name");
    slastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    TableColumn<Student, String> sidCol = new TableColumn<>("Id");
    sidCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    TableColumn<Student, Number> sageCol = new TableColumn<>("Age");
    sageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

    studentTableView.getColumns().addAll(sfirstNameCol, slastNameCol, sidCol, sageCol);
    ArrayList<Student> studentArrayList =
        new ArrayList<>() {
          {
            add(new Student("sfirst1", "slast1", "sid1", 110));
            add(new Student("sfirst2", "slast2", "sid2", 111));
            add(new Student("sfirst3", "slast3", "sid3", 112));
          }
        };
    studentTableView.getItems().setAll(studentArrayList);
  }
}
