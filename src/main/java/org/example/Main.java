package org.example;

import cz.uhk.gui.MainWindow;
import cz.uhk.rozvrh.RozvrhovaAkce;
import cz.uhk.rozvrh.NacteniDatZeStagu;

import javax.swing.*;
import java.util.List;


/**
 * Starter
 */
public class Main {
    public static void main(String[] args) {
        //Zkusime J1 na zimni semestr v budove J
        NacteniDatZeStagu nacitac = new NacteniDatZeStagu();
        List<RozvrhovaAkce> activities = nacitac.getRoomActivites("J", "J1");
        //vypis do konzole pomoci println a Activity.toString()
        activities.forEach(System.out::println);

    }
}