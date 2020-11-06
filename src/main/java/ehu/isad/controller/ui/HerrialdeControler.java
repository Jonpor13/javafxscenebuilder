package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Ezarpena;
import ehu.isad.model.HerrialdeModel;
import ehu.isad.utils.IrudiKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HerrialdeControler extends Parent implements Initializable {
    @FXML
    private TableView<HerrialdeModel> tbData;
    @FXML
    public TableColumn<HerrialdeModel, Image> bandera;
    @FXML
    public TableColumn<HerrialdeModel, String> herrialdea;
    @FXML
    public TableColumn<HerrialdeModel, String> artista;
    @FXML
    public TableColumn<HerrialdeModel, String> abestiak;
    @FXML
    public TableColumn<HerrialdeModel, Integer> puntuak;
    @FXML
    private ImageView imaHerri;
    @FXML
    private ImageView imaEuro;
    @FXML
    private Label lblHerri;
    @FXML
    private Button btmGorde;


    private Main mainApp;

    @FXML
    void onClick(ActionEvent event) {

    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    private List<String> herrialdeak(){
        return EzarpenakDBKud.getInstantzia().lortuHerrialdenIzenak();
    }

    // add your data here from any source
    private ObservableList<HerrialdeModel> herrialdeModels;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bandera.setCellValueFactory(new PropertyValueFactory<>("Bandera"));
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        artista.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        abestiak.setCellValueFactory(new PropertyValueFactory<>("Abestiak"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));
        // modeloaren datuak taulan txertatu
        tbData.setItems(herrialdeModels);
        this.euroLogoKargatu();
    }

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
        lblHerri.setText(hIzena + " horrela nahi ditu\n" +
                "bere puntuak banatu:");

    }

}