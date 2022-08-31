package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class Cook {
    private String name;
    private Queue<Hamburger> burgerTray;

    public Cook(String name, Queue<Hamburger> burgerTray) {
        this.name = name;
        this.burgerTray = burgerTray;
    }

    public synchronized void makeOrder(Hamburger burger) {//kun en tråd kan legge til burger av gangen
        burgerTray.enQueue(burger);//legger til burger i køen
        System.out.println("Cook " + name + " is adding burger: " + burger.getId() + " traycount: " + burgerTray.size());

    }

    public String getName() {
        return name;
    }
}