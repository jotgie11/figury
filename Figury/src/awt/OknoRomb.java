package awt;

import app.Figura;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class OknoRomb extends OknoFigura{
    TextField textFieldBok;
    Label labelBok;
    TextField textFieldHeight;
    Label labelHeight;
    public OknoRomb(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        labelBok = new Label("Bok");
        textFieldBok = new TextField("Wpisz długość boku");
        labelHeight = new Label("Wysokość");
        textFieldHeight = new TextField("Wpisz długość wysokości");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(labelBok,c);
        c.gridx = 1;
        c.gridy = 1;
        add(textFieldBok,c);
        c.gridx = 0;
        c.gridy = 2;
        add(labelHeight, c);
        c.gridx = 1;
        c.gridy = 2;
        add(textFieldHeight, c);
        textFieldBok.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Objects.equals(textFieldBok.getText(), "Wpisz długość boku")){
                    textFieldBok.setText("");
                }
            }
        });
        textFieldHeight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Objects.equals(textFieldHeight.getText(), "Wpisz długość wysokości")){
                    textFieldHeight.setText("");
                }
            }
        });
    }

    @Override
    public Figura getFigura() {
        double bok = Double.parseDouble(textFieldBok.getText());
        double wysokosc = Double.parseDouble(textFieldHeight.getText());
        Figura tmp = new Figura(textFieldNazwa.getText(),"romb", Math.round(bok * wysokosc * 100.0) / 100.0);
        return tmp;
    }
}

