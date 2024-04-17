package awt;

import app.Figura;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class OknoFigura extends Frame {
    Label labelnazwa;
    TextField textFieldNazwa;
    Button buttonOK;

    OknoStart parent;
    public OknoFigura(String title , OknoStart parent) throws HeadlessException {
        super(title);
        this.parent = parent;
        labelnazwa = new Label("Nazwa ");
        textFieldNazwa = new TextField("Wpisz nazwe");
        buttonOK = new Button("OK");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(labelnazwa,c);
        c.gridx = 1;
        c.gridy = 0;
        add(textFieldNazwa,c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth =2;
        add(buttonOK,c);
        setSize(280,200);
        setVisible(true);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.closeFiguraWindows();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                parent.setEnabled(true);
                dispose();
            }
        });
        textFieldNazwa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Objects.equals(textFieldNazwa.getText(), "Wpisz nazwe"))
                    textFieldNazwa.setText("");
            }
        });

    }

    public Figura getFigura() {
        return null;
    }
}
