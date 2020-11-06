package ehu.isad.model;

import javafx.scene.image.Image;

public class HerrialdeModel {

    private Image bandera;
    private String herrialdea;
    private String artista;
    private String abestiak;
    private Integer puntuak;

    public HerrialdeModel(Image bandera, String herrialdea, String artista, String abestiak, Integer puntuak) {
        this.bandera = bandera;
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestiak = abestiak;
        this.puntuak = puntuak;
    }

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbestiak() {
        return abestiak;
    }

    public void setAbestiak(String abestiak) {
        this.abestiak = abestiak;
    }

    public Integer getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(Integer puntuak) {
        this.puntuak = puntuak;
    }
}