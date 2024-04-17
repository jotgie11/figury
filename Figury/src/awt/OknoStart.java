package awt;

import app.Figura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

public class OknoStart extends Frame {
    Label labeLista;
    Label labelChoice;
    List listFigury;
    Choice choiceFigury;
    Button buttonDodaj;
    Button buttonInfo;
    Button buttonDelete;
    Menu menu;
    MenuItem menuItemZapisz;
    MenuItem menuItemWczytaj;
    MenuItem menuItemCzysc;
    MenuItem menuItemKoniec;
    Menu menuPomoc;
    MenuBar menuBar;
    OknoFigura oknoFigura;
    OknoInfo oknoInfo;
    ArrayList <Figura> bazaFigur;
    public OknoStart(String title, ArrayList<Figura> bazaFigur) throws HeadlessException {
        super(title);
        this.bazaFigur = bazaFigur;
        setSize(280,250);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        labeLista = new Label("Lista FIGUR");
        add(labeLista,c);
        labelChoice = new Label("wybierz figure:");
        c.gridx = 1;
        c.gridy = 0;
        add(labelChoice,c);
        choiceFigury = new Choice();
        choiceFigury.add("Koło");
        choiceFigury.add("Kwadrat");
        choiceFigury.add("Prostokąt");
        choiceFigury.add("Romb");
        c.gridx = 1;
        c.gridy = 1;
        c.weighty = 1.0;
        add(choiceFigury,c);
        Dimension dimensionButton = new Dimension( 100,30);
        buttonDodaj = new Button("Dodaj");
        buttonDodaj.setPreferredSize(dimensionButton);
        c.gridx = 1;
        c.gridy = 2;
        add(buttonDodaj,c);
        buttonDelete = new Button("Usuń");
        buttonDelete.setPreferredSize(dimensionButton);
        c.gridx = 1;
        c.gridy = 3;
        add(buttonDelete, c);
        buttonInfo = new Button("Dane");
        c.gridx = 1;
        c.gridy = 4;
        buttonInfo.setPreferredSize(dimensionButton);
        add(buttonInfo,c);
        listFigury = new List();
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 8;
        c.fill = GridBagConstraints.VERTICAL;

        add(listFigury,c);
        menu = new Menu("Polecenia");
        menuItemCzysc = new MenuItem("Czyść");
        menuItemKoniec = new MenuItem("Koniec");
        menuItemWczytaj = new MenuItem("Wczytaj");
        menuItemZapisz = new MenuItem("Zapisz");
        menuPomoc = new Menu("Pomoc");
        menu.add(menuItemCzysc);
        menu.add(menuItemWczytaj);
        menu.add(menuItemZapisz);
        menu.add(menuItemKoniec);
        menuBar = new MenuBar();
        menuBar.add(menu);
        menuBar.add(menuPomoc);
        setMenuBar(menuBar);
        setVisible(true);

        menuItemZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (ObjectOutputStream ouS = new ObjectOutputStream(new FileOutputStream("figury.bin"))) {
                    ouS.writeObject(bazaFigur);
                } catch (FileNotFoundException evt) {
                    throw new RuntimeException(evt);
                } catch (IOException evt) {
                    throw new RuntimeException(evt);
                }
            }
        });

        menuItemWczytaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (ObjectInputStream inS = new ObjectInputStream(new FileInputStream("figury.bin"))) {
                    ArrayList<Figura>bazaFigur2 = (ArrayList<Figura>) inS.readObject();
                    bazaFigur.clear();
                    for (int i = 0; i < bazaFigur2.size(); i++){
                        bazaFigur.add(bazaFigur2.get(i));
                    }
                    listFigury.removeAll();
                    for (int i = 0; i < bazaFigur.size(); i++){
                        listFigury.add(bazaFigur.get(i).getTyp()+": "+bazaFigur.get(i).getNazwa());
                    }
                } catch (IOException evt) {
                    throw new RuntimeException(evt);
                } catch (ClassNotFoundException evt) {
                    throw new RuntimeException(evt);
                }
            }
        });

        buttonDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFiguraWindow(choiceFigury.getSelectedItem());
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bazaFigur.remove(listFigury.getSelectedIndex());
                listFigury.remove(listFigury.getSelectedIndex());
            }
        });


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        buttonInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInfo();
            }

        });

    }
    void addFiguraWindow (String selectedItem){
            this.setEnabled(false);
            switch(selectedItem){
                case "Kwadrat": oknoFigura = new OknoKwadrat("Kwadrat",this);break;
                case "Koło":  oknoFigura = new OknoKolo("Koło",this);break;
                case "Prostokąt":  oknoFigura = new OknoProstokat("Prostokąt", this);break;
                case "Romb":  oknoFigura = new OknoRomb("Romb",this);break;
                default: this.setEnabled(true);
            }

    }

    public void closeFiguraWindows() {
        Figura  tmp  = oknoFigura.getFigura();
        listFigury.add(tmp.getTyp()+": "+tmp.getNazwa());
        bazaFigur.add(tmp);
        oknoFigura.dispose();
        this.setEnabled(true);
    }
    void showInfo(){
        this.setEnabled(false);
        int i = listFigury.getSelectedIndex();
        oknoInfo = new OknoInfo("Informacja o figurze",this);
        Figura f = bazaFigur.get(i);
        oknoInfo.setData(f.getNazwa(),f.getTyp(),f.getPole());
    }


    public void closeInfo() {
        oknoInfo.dispose();
        this.setEnabled(true);
    }
}
