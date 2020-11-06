package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.utils.IrudiKud;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class NagusiaKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private ImageView image;

  public void setMainApp(Main main) {
    this.mainApp = main;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {

      mainApp.ezarpenakErakutsi();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    Image argazkia = IrudiKud.getInstantzia().euroLogoKargatu();
    image.setImage(argazkia);

  }

}