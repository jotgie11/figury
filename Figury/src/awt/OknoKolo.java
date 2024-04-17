package awt;

import app.Figura;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class OknoKolo extends OknoFigura {
    Label labelPromien;
    TextField textFieldPromien;
    public OknoKolo(String title, OknoStart parent) throws HeadlessException {
        super(title, parent);
        labelPromien = new Label("Promień:");
        textFieldPromien = new TextField("Wpisz promień");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx= 0;
        c.gridy = 1;
        add(labelPromien,c);
        c.gridx= 1;
        c.gridy= 1;
        add(textFieldPromien,c);
        textFieldPromien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Objects.equals(textFieldPromien.getText(), "Wpisz promień"))
                    textFieldPromien.setText("");
            }
        });
    }

    @Override
    public Figura getFigura() {
        double promien = Double.parseDouble(textFieldPromien.getText());
        Figura tmp = new Figura(textFieldNazwa.getText(),"koło", Math.round(Math.PI * (promien * promien) * 100.0) / 100.0);
        return tmp;
    }
}
