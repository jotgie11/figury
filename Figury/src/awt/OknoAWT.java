package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OknoAWT extends Frame {
    Button przycisk;
    Button przycisk2;
    Button przycisk3;
    Label label1;
    Checkbox checkbox1;
    Checkbox checkbox2;
    CheckboxGroup checkboxGroup;
    List list;
    Panel panel;
    Choice choice;


    public OknoAWT(String title) throws HeadlessException {
        super(title);
        setSize(300,400);
        przycisk = new Button("Dodaj tekst");
        przycisk2 = new Button("Dodaj tekst2");
        przycisk3 = new Button("Dodaj tekst3");
        label1 = new Label("Ala ma psa",Label.CENTER);
        checkboxGroup = new CheckboxGroup();
        checkbox1 = new Checkbox("opcja1",true,checkboxGroup);
        checkbox2 = new Checkbox("opcja2",true,checkboxGroup);
        list = new List();
        choice = new Choice();
        choice.add("wybierz 1");
        choice.add("wybierz 2");
        choice.add("wybierz 3");
        panel = new Panel();

        this.setLayout( new GridBagLayout());
        // this.setLayout( new BorderLayout());
        //GridBagConstraints c = new GridBagConstraints();

        this.add(przycisk);
        this.add(przycisk2);
        /*
        c.gridx = 3;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        */
        this.add(przycisk3);
        this.add(label1);
        this.add(panel);
        panel.add(checkbox1);
        panel.add(checkbox2);
        this.add(list);
        this.add(choice);

        this.setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
    }
}

