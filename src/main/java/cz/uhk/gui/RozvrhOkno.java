package cz.uhk.gui;
import cz.uhk.rozvrh.NacteniDatZeStagu;
import cz.uhk.rozvrh.Provider;
import cz.uhk.rozvrh.RozvrhovaAkce;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class RozvrhOkno {

    JFrame frame;
    JTable table;
    JTextField budovaField;
    JTextField mistnostField;
    DefaultTableModel model;

    int zoufalstvi = 1;

    JToolBar menuVyberu;

    RozvrhOkno(){
        frame = new JFrame();
        frame.setTitle("Rozvrh");
        frame.setLayout(new BorderLayout());

        JToolBar toolBar = createFiltr();
        frame.add(toolBar, BorderLayout.NORTH);

        String[] ColumNames = {"Predmet" , "Nazev" ,"Mistnost","typ Akce" ,"Den","Start" , "Konec", "Ucitel"};
        //preparsovat a projet foreachem
        model = new DefaultTableModel(ColumNames, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);
        frame.add(scroll, BorderLayout.CENTER);

        Provider provider = new NacteniDatZeStagu();
        List<RozvrhovaAkce> rozvrhoveAkce = provider.getRoomActivites("J", "J1");

        Object[][] data = new Object[rozvrhoveAkce.size()][ColumNames.length];


        int index = 0;
        for (RozvrhovaAkce akce : rozvrhoveAkce) {
            data[index][0] = akce.getModule();
            data[index][1] = akce.getName();
            data[index][2] = akce.getRoom();
            data[index][3] = akce.getType();
            data[index][4] = akce.getDay();
            data[index][5] = akce.getTimeFrom();
            data[index][6] = akce.getTimeTo();
            data[index][7] = akce.getTeacher();
            index++;
        }

        table = new JTable(data, ColumNames);


       refreshTable("J","J1");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public JToolBar createFiltr() {
        JToolBar toolBar = new JToolBar();

        budovaField = new JTextField(1);
        mistnostField = new JTextField(2);
        JButton filtrButton = new JButton("Filtr");

        toolBar.add(new JLabel("Budova:"));
        toolBar.add(budovaField);
        toolBar.add(new JLabel("Místnost:"));
        toolBar.add(mistnostField);
        toolBar.add(filtrButton);


        filtrButton.addActionListener(e -> {
            String budova = budovaField.getText();
            String mistnost = mistnostField.getText();
            refreshTable(budova, mistnost);
        });
        return toolBar;
    }

    public void refreshTable(String X, String Y){

        Provider provider = new NacteniDatZeStagu();
        List<RozvrhovaAkce> rozvrhoveAkce = provider.getRoomActivites(X, Y);

        // Smazat staré řádky
        model.setRowCount(0);

        // Přidat nové řádky
        for (RozvrhovaAkce akce : rozvrhoveAkce) {
            model.addRow(new Object[]{
                    akce.getModule(),
                    akce.getName(),
                    akce.getRoom(),
                    akce.getType(),
                    akce.getDay(),
                    akce.getTimeFrom(),
                    akce.getTimeTo(),
                    akce.getTeacher()
            });
        }
    }





    public static void main(String[] args) {
        new RozvrhOkno();
    }


}
