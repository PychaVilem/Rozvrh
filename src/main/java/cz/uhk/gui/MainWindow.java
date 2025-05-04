package cz.uhk.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

    private JToolBar menu;
    private char[] budovyVyber;

    private JComboBox<String> budovaCB = new JComboBox<>();
    private JComboBox<String> mistnostCB = new JComboBox<>();
    private JButton nacti;

    private JFrame  frame;
    JTable table = new JTable();



    public MainWindow() {
        super("rozvrh");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); //velikosti okna
        setLocationRelativeTo(null); //vycentrovani vuci cele obrazovce


        vygenerujRozvrh();
        vytvorMenu();



    }

    public void actionPerformed(ActionEvent e) {

        // Check if the Start button was pushed
        if (e.getSource() == nacti) {
           vygenerujRozvrh();
        }
    }
    public void ActionListener(ActionEvent e) {
        if (e.getSource() == nacti) {
            vygenerujRozvrh();
        }
    }

    private void vytvorMenu(){

        menu = new JToolBar(JToolBar.HORIZONTAL);
        add(menu, BorderLayout.NORTH);

        String[] vyberBudov = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] vyberMistnost = {"A1", "B1", "C1", "D1", "E1", "F2"};

        budovaCB = new JComboBox<>(vyberBudov);
        mistnostCB = new JComboBox<>(vyberMistnost);
        nacti = new JButton("Nacti");

        menu.add(new JLabel("Rozvrh"));
        menu.add(budovaCB);
        menu.add(mistnostCB);
        menu.add(nacti);

       // nacti.addActionListener();

    }

    private void vygenerujRozvrh(){

    }
}
