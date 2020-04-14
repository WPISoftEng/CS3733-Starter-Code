package edu.wpi.teamname.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class FXMLLoaderFactoryTest {

  @Mock Injector injector;

  @InjectMocks FXMLLoaderFactory factory;

  private static final String RESULT_STRING = "ResultString";

  @BeforeEach
  public void init() {
    when(injector.getInstance(String.class)).thenReturn(RESULT_STRING);
  }

  @Test
  public void testFactoryHasInjector() {
    FXMLLoader loader = factory.createInjectedFXMLLoader();
    assertEquals(RESULT_STRING, loader.getControllerFactory().call(String.class));
  }
}
