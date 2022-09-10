package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class HamburgerTray {
    Queue<Hamburger> burgerTray;

    public HamburgerTray(Queue<Hamburger> tray) {
        this.burgerTray = tray;
    }

    @Override
    public String toString() {

        StringBuilder tray = new StringBuilder("[ ");

        for (int i = 0; i < burgerTray.size(); i++) {

            tray.append("{").append(burgerTray.getElement(i).getId()).append("}");

            if (i < burgerTray.size() - 1)
                tray.append(", ");
        }
        return tray.append(" ]").toString();
    }
}//class