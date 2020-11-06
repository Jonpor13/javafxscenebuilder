package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent nagusiaUI;
  private Parent ezarpenakUI;
  private Parent taulaUI;
  private Parent ezinBotaUI;
  private Parent top3UI;

  private Stage stage;

  private NagusiaKud nagusiaKud;
  private EzarpenakKud ezarpenakKud;
  private HerrialdeControler herrialdeKud;
  private EzinBotatuKud ezinBotatuKud;
  private Top3Kud top3Kud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(new Scene(nagusiaUI, 525, 225));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/NagusiaUI.fxml"));
    nagusiaUI = (Parent) loaderKautotu.load();
    nagusiaKud = loaderKautotu.getController();
    nagusiaKud.setMainApp(this);

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/EzarpenakUI.fxml"));
    ezarpenakUI = (Parent) loaderMain.load();
    ezarpenakKud = loaderMain.getController();
    ezarpenakKud.setMainApp(this);

    FXMLLoader loaderEzin = new FXMLLoader(getClass().getResource("/EzinBotatuUI.fxml"));
    ezinBotaUI = (Parent) loaderEzin.load();
    ezinBotatuKud = loaderEzin.getController();
    ezinBotatuKud.setMainApp(this);

    FXMLLoader loaderTaula = new FXMLLoader(getClass().getResource("/TableUI.fxml"));
    taulaUI = (Parent) loaderTaula.load();
    herrialdeKud = loaderTaula.getController();
    herrialdeKud.setMainApp(this);

    FXMLLoader loaderTop3 = new FXMLLoader(getClass().getResource("/Top3UI.fxml"));
    top3UI = (Parent) loaderTop3.load();
    top3Kud = loaderTop3.getController();
    top3Kud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void ezarpenakErakutsi() {
    stage.setScene(new Scene(ezarpenakUI));
    stage.show();
  }

  public void ezinBotatuErakutsi(String hIzena) {
    stage.setScene(new Scene(ezinBotaUI));
    ezinBotatuKud.setIzena(hIzena);
    ezinBotatuKud.banderaKargatu(hIzena);
    stage.show();
  }

  public void herrialdeTableErakutsi(String hIzena){
    stage.setScene(new Scene(taulaUI));
    herrialdeKud.setIzena(hIzena);
    herrialdeKud.banderaKargatu(hIzena);
    herrialdeKud.botoakKudeatu(hIzena);
    stage.show();
  }
  public void top3Erakutsi(){
    stage.setScene(new Scene(top3UI));
    stage.show();
  }

}
