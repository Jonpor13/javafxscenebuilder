package ehu.isad.controller.db;

import ehu.isad.model.Ezarpena;

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

}
