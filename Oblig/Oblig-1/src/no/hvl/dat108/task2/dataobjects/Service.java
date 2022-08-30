package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.Main;
import no.hvl.dat108.task2.adt.Queue;

public class Service extends Main {
    private String name;
    private Queue<Hamburger> tray;
    public Service(String name, Queue<Hamburger> tray) {
        this.name = name;
        this.tray = tray;
    }
    public synchronized void deliver(){ //kun en servitør kan lever burger av gangen

        if(burgers>0){ //så lenge køen ikke er tom
            tray.deQueue(); //fjern øverste burger i fra køen
            System.out.println("Server " + name + " is serving a burger, traycount: " + tray.size());
        }else{
            System.out.println("The tray is empty " + name + " cannot serve a burger");
        }
    }


    public String getName() {
        return name;
    }
}