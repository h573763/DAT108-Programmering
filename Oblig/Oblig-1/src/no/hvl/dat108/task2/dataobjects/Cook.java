package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

import java.util.ArrayList;

public class Cook{
    private String name;
    private Queue<Hamburger> burgerTray;

    public Cook(String name, Queue<Hamburger> burgerTray) {
        this.name = name;
        this.burgerTray = burgerTray;
    }
    public synchronized void makeOrder(Hamburger burger){

        if(burgerTray.size() < burgerTray.getLim()) {
            burgerTray.enQueue(burger);
            System.out.println("Cook " + name + " is adding a " + burger.getName() + " traycount: " + burgerTray.size());

        }else{
            System.out.println("The tray is full " + name + " cannot make a burger");

        }
    }
    public String getName() {
        return name;
    }
}