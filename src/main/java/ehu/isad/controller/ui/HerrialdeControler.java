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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

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
        mainApp.top3Erakutsi();
    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    // add your data here from any source
    private ObservableList<HerrialdeModel> herrialdeModels;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tbData.setEditable(true);

        List<HerrialdeModel> herrialdeParteList = EzarpenakDBKud.getInstantzia().lortuHerrialdePartaide();
        herrialdeModels = FXCollections.observableArrayList(herrialdeParteList);

        bandera.setCellValueFactory(new PropertyValueFactory<>("Bandera"));
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        artista.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        abestiak.setCellValueFactory(new PropertyValueFactory<>("Abestiak"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));

        this.euroLogoKargatu();

        puntuak.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        Callback<TableColumn<HerrialdeModel, String>, TableCell<HerrialdeModel, String>> defaultTextFieldCellFactory
                = TextFieldTableCell.<HerrialdeModel>forTableColumn();

        herrialdea.setCellFactory(col -> {
            TableCell<HerrialdeModel, String> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if ( ! cell.isEmpty()) {

                    if (cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals("")) {
                        cell.setEditable(false);
                    }else {
                        cell.setEditable(true);
                    }
                }
            });

            return cell ;
        });


        bandera.setCellValueFactory(new PropertyValueFactory<HerrialdeModel, Image>("Bandera"));

        bandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(35);
                    imageview.setFitWidth(35);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });

        // modeloaren datuak taulan txertatu
        tbData.setItems(herrialdeModels);

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

    public void botoakKudeatu(String nork){
        puntuak.setOnEditCommit(
                t -> {
                    String nori = t.getTableView().getSelectionModel().getSelectedItem().getHerrialdea();

                    if ( ! nori.equals(nork)) {
                        t.getTableView().getItems().get(t.getTablePosition().getRow())
                                .setPuntuak(t.getNewValue());

                        Integer puntuak = t.getTableView().getItems().get(t.getTablePosition().getRow()).getPuntuak();

                        //behin botoak sartuta, nork nori eta zenbat puntu jarri dituen gordeko da
                        EzarpenakDBKud.getInstantzia().norkNoriPuntuak(nork, nori, puntuak);

                        //guztia eginda dagoala, herrialde bakotzari irabizi duten puntuak gehitu behar dira
                        EzarpenakDBKud.getInstantzia().puntuakGehitu(nori, puntuak);
                    }
                }
        );
    }

}