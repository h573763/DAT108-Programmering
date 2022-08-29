package no.hvl.dat108.task2;

import no.hvl.dat108.task2.adt.LinearNode;
import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Cook> cookList;
    static Queue<Hamburger> burgerQueue = new Queue<>();
    private static List<Service> serviceList;

    public static void main(String... blablabla) {

        HamburgerTray burgerTray = new HamburgerTray(burgerQueue);
        burgerTray.setMaxCap(4);

//        final String[] kokker = {"Anne", "Erik", "Knut"};
//        final String[] servitorer = {"Mia", "Per"};Á
        Hamburger burger = new Hamburger();
        cookList = new ArrayList<>();


        Cook carl = new Cook("carl", burgerTray);
//        Cook erik = new Cook();
//        Cook knut = new Cook();

        cookList.add(carl);
//        cookList.add(erik);
//        cookList.add(knut);
//
        for(int i = 0; i < 10; i++){
            carl.makeOrder(burger);
        }
        serviceList = new ArrayList<>();
        Service anne = new Service("Anna", burgerTray);
        Service chad = new Service("Henrik", burgerTray);

        serviceList.add(anne);
        serviceList.add(chad);



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
