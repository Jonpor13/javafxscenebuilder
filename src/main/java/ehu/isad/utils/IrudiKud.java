package ehu.isad.utils;

import ehu.isad.controller.db.EzarpenakDBKud;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IrudiKud {

    private static IrudiKud instantzia = new IrudiKud();

    public static IrudiKud getInstantzia(){
        return instantzia;
    };

    private IrudiKud (){}


    public Image euroLogoKargatu(){

        Properties properties = Utils.lortuEzarpenak();
        String path = properties.getProperty("logoarenPath");
        InputStream is = getClass().getResourceAsStream(path);
        BufferedImage reader = null;
        try {
            reader = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image argazkia = SwingFXUtils.toFXImage(reader,null);
        return argazkia;

    }

    public Image banderaKargatu(String bandera){

        Properties properties = Utils.lortuEzarpenak();
        String path = properties.getProperty("banderenPath") +bandera+ ".png";
        InputStream is = getClass().getResourceAsStream(path);
        BufferedImage reader = null;
        try {
            reader = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image argazkia = SwingFXUtils.toFXImage(reader,null);
        return argazkia;

    }
}
