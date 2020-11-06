package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Ezarpena;
import ehu.isad.utils.IrudiKud;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class EzinBotatuKud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView imaHerri;

    @FXML
    private ImageView imaEuro;

    @FXML
    private Button btnOkay;

    @FXML
    private Label lblText;

    public void setMainApp(Main main) {
        this.mainApp = main;
    }


    @FXML
    void onClick(ActionEvent event) {
        Stage stage = (Stage) btnOkay.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {this.euroLogoKargatu();}

    private void euroLogoKargatu(){
        Image argazkia = IrudiKud.getInstantzia().euroLogoKargatu();
        imaEuro.setImage(argazkia);
    }

    public void banderaKargatu(String hIzena){
        String bandera = EzarpenakDBKud.getInstantzia().lortuHerrialdenBanderak(hIzena);
        Image argazkia = IrudiKud.getInstantzia().banderaKargatu(bandera);
        imaHerri.setImage(argazkia);

    }
    public void setIzena(String hIzena){

        lblText.setText(hIzena + " jada banatu ditu\n" +
                "bere puntuak.");

    }



}

