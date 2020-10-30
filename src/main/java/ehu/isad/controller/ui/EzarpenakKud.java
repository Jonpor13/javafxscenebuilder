package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Ezarpena;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EzarpenakKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private ImageView imaEuro;

  @FXML
  private ComboBox<String> cbHerrialde;

  @FXML
  private Button btOK;

  public void setMainApp(Main main) {
    this.mainApp = main;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {
    String hIzena = cbHerrialde.getValue();
    mainApp.ezinBotatuErakutsi(hIzena);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.argazkiaKargatu();

    List<String> herrialdeList = EzarpenakDBKud.getInstantzia().lortuHerrialdenIzenak();
    ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrialdeList);

    cbHerrialde.setItems( herrialdeak );

  }

  private void argazkiaKargatu(){
    InputStream is = getClass().getResourceAsStream("/Eurovision_Song_Contest_logo.svg.png");
    BufferedImage reader = null;
    try {
      reader = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    Image argazkia = SwingFXUtils.toFXImage(reader,null);
    imaEuro.setImage(argazkia);

  }

}