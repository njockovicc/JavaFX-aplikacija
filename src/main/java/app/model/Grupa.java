package app.model;

import java.util.Objects;

public class Grupa implements Comparable<Grupa> {
    private String oznaka;
    private String dan;
    private int brojDana;
    private Integer brojCasova;

    public Grupa(String oznaka, String dan, Integer brojCasova) {
        this.oznaka = oznaka;
        this.dan = dan;
        this.brojCasova = brojCasova;
        setBrojDana();
    }

    public Grupa(){}

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public Integer getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(Integer brojCasova) {
        this.brojCasova = brojCasova;
    }

    public void setBrojDana() {
        if(dan.equals("PON"))
            brojDana = 1;
        else if(dan.equals("UTO"))
            brojDana = 2;
        else if(dan.equals("SRE"))
            brojDana = 3;
        else if(dan.equals("PET"))
            brojDana = 5;
        else brojDana = 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupa grupa = (Grupa) o;
        return Objects.equals(oznaka, grupa.oznaka) && Objects.equals(dan, grupa.dan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oznaka, dan);
    }

    @Override
    public int compareTo(Grupa o) {
        if(this.oznaka.equals(o.oznaka)) {
            return this.brojDana - o.brojDana;
        }

        return this.oznaka.compareTo(o.oznaka);
    }
}
