package edu.wpi.teamname.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
  private String firstName;
  private String lastName;
  private String id;
  private Integer age;
}
