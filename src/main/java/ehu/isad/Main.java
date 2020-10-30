package ehu.isad;

import ehu.isad.controller.ui.EzinBotatuKud;
import ehu.isad.controller.ui.NagusiaKud;
import ehu.isad.controller.ui.EzarpenakKud;
import ehu.isad.controller.ui.StudentsControler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent nagusiaUI;
  private Parent ezarpenakUI;
  private Parent tableUI;
  private Parent ezinBotaUI;

  private Stage stage;

  private NagusiaKud nagusiaKud;
  private EzarpenakKud ezarpenakKud;
  private StudentsControler studentKud;
  private EzinBotatuKud ezinBotatuKud;


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
    stage.show();

  }
}
