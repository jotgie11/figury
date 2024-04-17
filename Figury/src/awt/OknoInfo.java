package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OknoInfo extends Frame {
    OknoStart parent;
    Label labelNazwa;
    Label labelTyp;
    Label labelPole;

    public OknoInfo(String title, OknoStart oknoStart) throws HeadlessException {
        super(title);
        labelNazwa = new Label("Nazwa:");
        labelTyp = new Label("Typ:");
        labelPole = new Label("Pole:");

        setLayout(new GridLayout(3,1));
        add(labelNazwa);
        add(labelTyp);
        add(labelPole);

        setSize(300,150);
        parent = oknoStart;
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                parent.closeInfo();
            }
        });
    }

    public void setData(String nazwa, String typ, double pole) {
        labelNazwa.setText("Nazwa : "+nazwa);
        labelTyp.setText("Typ : "+typ);
        labelPole.setText("Pole : "+Double.toString(pole));
    }
}
