package edu.wpi.teamname.services;

import java.util.ArrayList;

public class ServiceTwo {

  /* Example other Service Class */
  public ArrayList<String> getResults() {
    return new ArrayList<String>() {
      {
        add("Result1");
        add("Result2");
      }
    };
  }
}
