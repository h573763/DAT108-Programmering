package no.hvl.dat108.task2;

import no.hvl.dat108.task2.dataobjects.HamburgerTray;

public class Main {
    public static void main(String... blablabla) {

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        skrivUtHeader(kokker, servitorer, KAPASITET);

        HamburgerTray tray = new HamburgerTray(KAPASITET);

        for (String navn : kokker) {
            new Kokk(brett, navn).start();
        }
        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
        }

    }
}
