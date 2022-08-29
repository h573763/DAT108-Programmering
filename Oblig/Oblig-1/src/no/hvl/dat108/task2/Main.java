package no.hvl.dat108.task2;

import no.hvl.dat108.task2.adt.LinearNode;
import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.*;
import no.hvl.dat108.task2.threads.ThreadController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Queue<Hamburger> burgerQueue = new Queue<>();

    public static void main(String... blablabla) {

        HamburgerTray burgerTray = new HamburgerTray(burgerQueue);
        burgerTray.setMaxCap(4);

        ThreadController threadController = new ThreadController();
        threadController.menu();
//        Hamburger burger = new Hamburger();
//
//        Service anne = new Service("Anna", burgerTray);
//        Service chad = new Service("Henrik", burgerTray);

//        final int KAPASITET = 4;
//
//        skrivUtHeader(kokker, servitorer, KAPASITET);
//
//        for (String navn : kokker) {
//            new Cook(brett, navn).start();
//        }
//        for (String navn : servitorer) {
//            new Service(brett, navn).start();
//        }
//
//    }
//
//    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
    }
}
