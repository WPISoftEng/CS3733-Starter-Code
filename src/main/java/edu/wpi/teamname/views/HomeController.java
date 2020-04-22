package edu.wpi.teamname.views;

import edu.wpi.teamname.entities.Employee;
import edu.wpi.teamname.entities.Student;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class HomeController implements Initializable {

  @FXML private TableView<Employee> employeeTableView;
  @FXML private TableView<Student> studentTableView;

  Employee emp1 = new Employee("first1", "last1", "id1", 10);
  Employee emp2 = new Employee("first2", "last2", "id2", 11);
  Employee emp3 = new Employee("first3", "last3", "id3", 12);

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
    firstNameCol.setCellValueFactory(param -> param.getValue().getFirstName());
    firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
    lastNameCol.setCellValueFactory(param -> param.getValue().getLastName());
    lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<Employee, String> idCol = new TableColumn<>("Id");
    idCol.setCellValueFactory(param -> param.getValue().getId());
    idCol.setCellFactory(TextFieldTableCell.forTableColumn());
    TableColumn<Employee, Number> ageCol = new TableColumn<>("Age");
    ageCol.setCellValueFactory(param -> param.getValue().getAge());
    ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

    employeeTableView.getColumns().addAll(firstNameCol, lastNameCol, idCol, ageCol);
    ArrayList<Employee> employeeArrayList =
        new ArrayList<>() {
          {
            add(emp1);
            add(emp2);
            add(emp3);
          }
        };
    employeeTableView.getItems().setAll(employeeArrayList);
    employeeTableView.setEditable(true);
    employeeTableView.getSelectionModel().cellSelectionEnabledProperty().set(true);

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

  public void print(ActionEvent actionEvent) {
    System.out.println(emp1);
    System.out.println(emp2);
    System.out.println(emp3);
  }
}
