package org.example;

import cz.uhk.gui.MainWindow;
import javax.swing.*;


/**
 * Starter
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new MainWindow().setVisible(true);
        });

    }
}