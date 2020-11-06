package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.HerrialdeModel;
import ehu.isad.utils.IrudiKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Top3Kud extends Parent implements Initializable {

    @FXML
    private ImageView imaEuro;
    @FXML
    private TableView<HerrialdeModel> tbData;
    @FXML
    public TableColumn<HerrialdeModel, Image> bandera;
    @FXML
    public TableColumn<HerrialdeModel, String> herrialdea;
    @FXML
    public TableColumn<HerrialdeModel, Integer> puntuak;
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

    private ObservableList<HerrialdeModel> herrialdeModels;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void euroLogoKargatu() {
        Image argazkia = IrudiKud.getInstantzia().euroLogoKargatu();
        imaEuro.setImage(argazkia);
    }

    public void top3Kargatu(){
        List<HerrialdeModel> herrialdeParteList = EzarpenakDBKud.getInstantzia().lortuTop3();
        herrialdeModels = FXCollections.observableArrayList(herrialdeParteList);

        bandera.setCellValueFactory(new PropertyValueFactory<>("bandera"));
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("puntuak"));

        bandera.setCellValueFactory(new PropertyValueFactory<HerrialdeModel, Image>("bandera"));

        bandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(35);
                    imageview.setFitWidth(35);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    //tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });

        tbData.setItems(herrialdeModels);
        this.euroLogoKargatu();
    }
}
