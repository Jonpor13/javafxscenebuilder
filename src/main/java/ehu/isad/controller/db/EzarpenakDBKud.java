package ehu.isad.controller.db;

import ehu.isad.model.Ezarpena;
import ehu.isad.model.HerrialdeModel;
import ehu.isad.utils.IrudiKud;
import javafx.scene.image.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EzarpenakDBKud {

  // singleton patroia

  private static EzarpenakDBKud instantzia = new EzarpenakDBKud();

  public static EzarpenakDBKud getInstantzia(){
      return instantzia;
  };

  private EzarpenakDBKud (){}

  public List<String> lortuHerrialdenIzenak(){

    List<String> emaitza = new ArrayList<>();
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select izena from ParteHartzea where urtea = '2020' AND etorrikoDa = 'bai'";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {

        String hIzena = rs.getString("izena");
        emaitza.add(hIzena);
      }
    }catch (SQLException e){
      System.err.println(e);
    }


    return emaitza;
  }

  public List<HerrialdeModel> lortuHerrialdePartaide(){

    List<HerrialdeModel> emaitza = new ArrayList<>();
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select o.artista, o.herrialdea, o.abestia, o.puntuak from Ordezkaritza o, ParteHartzea p where p.izena = o.herrialdea AND o.urtea = '2020' AND p.urtea = '2020' AND p.etorrikoDa = 'bai'";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {

        String oIzena = rs.getString("herrialdea");
        String bandera = EzarpenakDBKud.getInstantzia().lortuHerrialdenBanderak(oIzena);
        Image argazkia = IrudiKud.getInstantzia().banderaKargatu(bandera);
        emaitza.add(hIzena);
      }
    }catch (SQLException e){
      System.err.println(e);
    }


    return emaitza;
  }

  public String lortuHerrialdenBanderak(String hIzena){

    String hBandera = null;
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select bandera from Herrialde where izena = '"+hIzena+"';";
    ResultSet rs = dbkud.execSQL(query);

    try {
      if (rs.next()) {

        hBandera = rs.getString("bandera");

      }
    }catch (SQLException e){
      System.err.println(e);
    }


    return hBandera;
  }

  public String bozkatuDu(String hIzena) throws SQLException {

    String hBozkatu = null;
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select bozkatuDu from Bozkaketa where bozkatuDu = '"+hIzena+"';";
    ResultSet rs = dbkud.execSQL(query);

    if (rs.next()) {
      hBozkatu = rs.getString("bozkatuDu");
    }

    return hBozkatu;
  }

}
