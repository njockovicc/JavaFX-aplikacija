package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Raspored {
    private String profesor;
    private String predmet;
    private String vrsta;
    private List<String> grupe = new ArrayList<>();
    private String termin;
    private String dan;

    public Raspored(){

    }

    public Raspored(String profesor, String predmet, String vrsta, List<String> grupe, String termin, String dan) {
        this.profesor = profesor;
        this.predmet = predmet;
        this.vrsta = vrsta;
        this.grupe = grupe;
        this.termin = termin;
        this.dan = dan;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public List<String> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<String> grupe) {
        this.grupe = grupe;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }
}
