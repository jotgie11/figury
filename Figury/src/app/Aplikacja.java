package app;

import awt.OknoStart;

import java.util.ArrayList;

public class Aplikacja {

    public static void main(String[] args) {
        ArrayList <Figura> bazaFigur;
        bazaFigur = new ArrayList<Figura>();
        OknoStart oknoFigury = new OknoStart("FIGURY płaskie",bazaFigur);
    }
}
