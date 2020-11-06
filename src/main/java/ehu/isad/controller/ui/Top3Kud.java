package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.utils.IrudiKud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Top3Kud extends Parent implements Initializable {

    @FXML
    private ImageView imaEuro;

    @FXML
    private ImageView ima1;

    @FXML
    private ImageView ima2;

    @FXML
    private ImageView ima3;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Button btnOK;

    private Main mainApp;

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    void onClick(ActionEvent event) {
        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.euroLogoKargatu();
    }

    private void euroLogoKargatu(){
        Image argazkia = IrudiKud.getInstantzia().euroLogoKargatu();
        imaEuro.setImage(argazkia);
    }

    public void banderaKargatu(String hIzena){
        String bandera = EzarpenakDBKud.getInstantzia().lortuHerrialdenBanderak(hIzena);
        Image argazkia = IrudiKud.getInstantzia().banderaKargatu(bandera);
        ima1.setImage(argazkia);
    }
}
