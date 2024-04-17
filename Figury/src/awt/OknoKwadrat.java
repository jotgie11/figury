package awt;

import app.Figura;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class OknoKwadrat extends OknoFigura{
    TextField textFieldBok;
    Label labelBok;
    public OknoKwadrat(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        labelBok = new Label("Bok");
        textFieldBok = new TextField("Wpisz długość boku");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(labelBok,c);
        c.gridx = 1;
        c.gridy = 1;
        add(textFieldBok,c);
        textFieldBok.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Objects.equals(textFieldBok.getText(), "Wpisz długość boku"))
                    textFieldBok.setText("");
            }
        });
    }

    @Override
    public Figura getFigura() {
        double bok = Double.parseDouble(textFieldBok.getText());
        Figura tmp = new Figura(textFieldNazwa.getText(),"kwadrat", Math.round(bok * bok * 100.0) / 100.0);
        return tmp;
    }
}
