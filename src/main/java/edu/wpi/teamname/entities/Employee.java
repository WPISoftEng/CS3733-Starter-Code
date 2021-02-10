package edu.wpi.teamname.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Employee {

  private final SimpleStringProperty firstName = new SimpleStringProperty("");
  private final SimpleStringProperty lastName = new SimpleStringProperty("");
  private final SimpleStringProperty id = new SimpleStringProperty("");
  private final SimpleIntegerProperty age = new SimpleIntegerProperty();

  public Employee(String firstName, String lastName, String id, int age) {
    this.firstName.set(firstName);
    this.lastName.set(lastName);
    this.id.set(id);
    this.age.set(age);
  }
}
