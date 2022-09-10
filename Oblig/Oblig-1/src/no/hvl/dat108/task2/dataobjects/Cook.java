package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class Cook {
    private String name;
    private Queue<Hamburger> burgerTray;
    private HamburgerTray tray;

    public Cook(String name){
        this.name = name;
    }
    public Cook(String name, Queue<Hamburger> burgerTray) {
        this.name = name;
        this.burgerTray = burgerTray;
        tray = new HamburgerTray(burgerTray);
    }//constructor
    public synchronized void makeOrder(Hamburger burger) {
        //legger til burger i køen
        burgerTray.enQueue(burger);
        System.out.println("Cook " + name + " is adding burger: " + burger.getId() + ", tray: " + tray.toString());
    }
    public String getName() {
        return name;
    }
}//class