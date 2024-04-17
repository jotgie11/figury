package awt;

import app.Figura;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class OknoProstokat extends OknoFigura{
    TextField textFieldBok1;
    Label labelBok1;
    TextField textFieldBok2;
    Label labelBok2;
    public OknoProstokat(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        labelBok1 = new Label("Pierwszy bok");
        textFieldBok1 = new TextField("Wpisz długość boku");
        labelBok2 = new Label("Drugi bok");
        textFieldBok2 = new TextField("Wpisz długość boku");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(labelBok1,c);
        c.gridx = 1;
        c.gridy = 1;
        add(textFieldBok1,c);
        c.gridx = 0;
        c.gridy = 2;
        add(labelBok2, c);
        c.gridx = 1;
        c.gridy = 2;
        add(textFieldBok2, c);
        textFieldBok1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Objects.equals(textFieldBok1.getText(), "Wpisz długość boku")){
                    textFieldBok1.setText("");
                }
            }
        });
        textFieldBok2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Objects.equals(textFieldBok2.getText(), "Wpisz długość boku")){
                    textFieldBok2.setText("");
                }
            }
        });
    }

    @Override
    public Figura getFigura() {
        double bok1 = Double.parseDouble(textFieldBok1.getText());
        double bok2 = Double.parseDouble(textFieldBok2.getText());
        Figura tmp = new Figura(textFieldNazwa.getText(),"prostokąt", Math.round(bok1 * bok2 * 100.0) / 100.0);
        return tmp;
    }
}

