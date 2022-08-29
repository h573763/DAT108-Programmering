package no.hvl.dat108.task2;

import no.hvl.dat108.task2.dataobjects.Cook;
import no.hvl.dat108.task2.dataobjects.HamburgerTray;
import no.hvl.dat108.task2.dataobjects.Service;

public class Main {
    public static void main(String... blablabla) {

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        skrivUtHeader(kokker, servitorer, KAPASITET);

        HamburgerTray tray = new HamburgerTray(KAPASITET);

        for (String navn : kokker) {
            new Cook(brett, navn).start();
        }
        for (String navn : servitorer) {
            new Service(brett, navn).start();
        }

    }

    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        for(String x:kokker)
            System.out.println(x);
        for(String x:servitorer)
            System.out.println(x);
        System.out.println(kapasitet);
    }
}
