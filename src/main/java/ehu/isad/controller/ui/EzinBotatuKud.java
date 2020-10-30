package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
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

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       this.argazkiaKargatu();
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
    public void setIzena(String hIzena){

        lblText.setText(hIzena + " jada banatu ditu\n" +
                "bere puntuak.");

    }



}

