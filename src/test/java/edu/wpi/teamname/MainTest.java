/** ****************************************** */
/*       DO NOT DELETE THIS TEST CLASS       */
/** ****************************************** */
package edu.wpi.teamname;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void testMainClass() throws ClassNotFoundException {
    assertEquals(Main.class, Class.forName("edu.wpi.teamname.Main"));
  }
}
