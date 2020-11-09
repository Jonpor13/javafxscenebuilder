package ehu.isad.model;

public class BozkaketaModel {
    private String herrialdea;
    private Integer puntuak;

    public BozkaketaModel(String herrialdea, Integer puntuak) {
        this.herrialdea = herrialdea;
        this.puntuak = puntuak;
    }

    @Override
    public boolean equals(Object obj) {
        return herrialdea==obj.toString();
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public Integer getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(Integer puntuak) {
        this.puntuak = puntuak;
    }


}

