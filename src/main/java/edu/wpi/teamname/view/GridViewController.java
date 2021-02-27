package edu.wpi.teamname.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GridViewController implements Initializable {

  @FXML private GridPane grid;
  @FXML private ImageView imageView;
  @FXML private AnchorPane imageAnchorPane;
  private final Scene primaryScene;

  public GridViewController(Scene primaryScene) {
    this.primaryScene = primaryScene;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    imageView.setPreserveRatio(false);
    imageView.fitWidthProperty().bind(primaryScene.widthProperty().divide(3));
    imageView.fitHeightProperty().bind(primaryScene.heightProperty().divide(3));
  }
}
