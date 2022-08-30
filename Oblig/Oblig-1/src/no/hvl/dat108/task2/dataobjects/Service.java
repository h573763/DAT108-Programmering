package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class Service {
    private String name;
    private Queue<Hamburger> tray;
    public Service(String name, Queue<Hamburger> tray) {
        this.name = name;
        this.tray = tray;
    }
    public synchronized void deliver(){

        if(!(tray.isEmpty())){
            tray.deQueue();
            System.out.println("Server " + name + " is serving a burger, traycount: " + tray.size());
        }else{
            System.out.println("The tray is empty " + name + " cannot serve a burger");
        }
    }


    public String getName() {
        return name;
    }
}