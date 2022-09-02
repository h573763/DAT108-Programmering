package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class Service{
    private String name;
    private Queue<Hamburger> tray;
    public Service(String name, Queue<Hamburger> tray) {
        this.name = name;
        this.tray = tray;
    }//constructor
    public synchronized void deliver(Hamburger burger) {
        //fjern øverste burger i fra køen
        if (!(tray.isEmpty() && tray.isNull())) {
            tray.deQueue();
            System.out.println("Server " + name + " is serving a burger: " + burger.getId() + " traycount: " + tray.size());
        }
    }
    public String getName() {
        return name;
    }
}//class