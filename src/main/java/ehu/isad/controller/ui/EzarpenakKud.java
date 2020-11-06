package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.utils.IrudiKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
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
  public void onClick(ActionEvent actionEvent) throws SQLException {
    String hIzena = cbHerrialde.getValue();
    String bozkatu = EzarpenakDBKud.getInstantzia().bozkatuDu(hIzena);

    if (bozkatu != null){ //hau da, herrialde horrek bozkatu badu...
      mainApp.ezinBotatuErakutsi(hIzena);
    }

    else {
      mainApp.herrialdeTableErakutsi(hIzena);
    }

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.euroLogoKargatu();

    List<String> herrialdeList = EzarpenakDBKud.getInstantzia().lortuHerrialdenIzenak();
    ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrialdeList);

    cbHerrialde.setItems( herrialdeak );

  }

  private void euroLogoKargatu(){
    Image argazkia = IrudiKud.getInstantzia().euroLogoKargatu();
    imaEuro.setImage(argazkia);

  }

}