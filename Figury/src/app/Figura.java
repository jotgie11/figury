package app;

import java.io.Serializable;

public class Figura implements Serializable {
     String nazwa;
     String typ;
     Double pole;

    public Figura(String nazwa, String typ, Double pole) {
        this.nazwa = nazwa;
        this.typ = typ;
        this.pole = pole;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public Double getPole() {
        return pole;
    }
}
