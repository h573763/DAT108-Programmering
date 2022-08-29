package no.hvl.dat108.task2.dataobjects;

import java.util.ArrayList;

public class Cook{
    private String name;
    private HamburgerTray burgerTray;

    public Cook(String name, HamburgerTray burgerTray) {
        this.name = name;
        this.burgerTray = burgerTray;
    }
    public void makeOrder(Hamburger burger){
        burgerTray.add(burger);
    }
}
