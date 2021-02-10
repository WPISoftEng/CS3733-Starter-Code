package edu.wpi.teamname.views;

import edu.wpi.teamname.entities.Employee;
import edu.wpi.teamname.entities.Student;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class HomeController implements Initializable {

  private final Employee emp1 = new Employee("first1", "last1", "id1", 10);
  private final Employee emp2 = new Employee("first2", "last2", "id2", 11);
  private final Employee emp3 = new Employee("first3", "last3", "id3", 12);
  @FXML private TableView<Employee> employeeTableView;
  @FXML private TableView<Student> studentTableView;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // First Name column will turn an `Employee` into a `String
    TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
    // To create the string from the employee, we call `Employee::getFirstName` on the Employee
    // object
    firstNameCol.setCellValueFactory(param -> param.getValue()
        .getFirstName());
    // To make the cell editable, we need to make the cell in the table be rendered as a TextField
    firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
    lastNameCol.setCellValueFactory(param -> param.getValue()
        .getLastName());
    lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<Employee, String> idCol = new TableColumn<>("Id");
    idCol.setCellValueFactory(param -> param.getValue()
        .getId());
    // We do not set the cell factory for the id column because we don't want to be able to edit it

    TableColumn<Employee, Number> ageCol = new TableColumn<>("Age");
    ageCol.setCellValueFactory(param -> param.getValue()
        .getAge());
    ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

    // Combine the TableColumns into a collection to be added to the TableView
    List<TableColumn<Employee, ?>> employeeColumns =
        new ArrayList<TableColumn<Employee, ?>>() {
          {
            add(firstNameCol);
            add(lastNameCol);
            add(idCol);
            add(ageCol);
          }
        };
    employeeTableView.getColumns()
        .addAll(employeeColumns);

    ArrayList<Employee> employeeArrayList =
        new ArrayList<Employee>() {
          {
            add(emp1);
            add(emp2);
            add(emp3);
          }
        };
    employeeTableView.getItems()
        .addAll(employeeArrayList);
    employeeTableView.setEditable(true);
    employeeTableView.getSelectionModel()
        .cellSelectionEnabledProperty()
        .set(true);

    TableColumn<Student, String> studentFirstNameCol = new TableColumn<>("First Name");
    // Use the `firstName` property of `Student` as the value of this cell
    // Student must have `getFirstName` and `setFirstName` fields. Lombok provides these in this example code
    studentFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    studentFirstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<Student, String> studentLastNameCol = new TableColumn<>("Last Name");
    studentLastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

    TableColumn<Student, String> studentIdColumn = new TableColumn<>("Id");
    studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn<Student, Number> studentAgeCol = new TableColumn<>("Age");
    studentAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));

    List<TableColumn<Student, ?>> studentColumns =
        new ArrayList<TableColumn<Student, ?>>() {
          {
            add(studentFirstNameCol);
            add(studentLastNameCol);
            add(studentIdColumn);
            add(studentAgeCol);
          }
        };
    studentTableView.getColumns()
        .addAll(studentColumns);

    ArrayList<Student> studentArrayList =
        new ArrayList<Student>() {
          {
            add(new Student("sfirst1", "slast1", "sid1", 110));
            add(new Student("sfirst2", "slast2", "sid2", 111));
            add(new Student("sfirst3", "slast3", "sid3", 112));
          }
        };
    studentTableView.getItems()
        .addAll(studentArrayList);
    studentTableView.setEditable(true);
    studentTableView.getSelectionModel()
        .cellSelectionEnabledProperty()
        .set(true);
  }

  @FXML
  private void printClicked() {
    System.out.println(emp1);
    System.out.println(emp2);
    System.out.println(emp3);
  }
}
