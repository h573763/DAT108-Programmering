package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class HamburgerTray{
    Queue<Hamburger> burgerTray;
    private int trayMax;
    public HamburgerTray(Queue<Hamburger> tray){
        this.burgerTray = tray;
    }

    public synchronized void add(Hamburger burger){

        burgerTray.enQueue(burger);
        System.out.println("" + burger.getName());
        System.out.println(burgerTray.size());
    }
    public synchronized Hamburger remove(){
        return burgerTray.deQueue();
    }
    public void setMaxCap(int cap){
        this.trayMax = cap;
    }
    public int getMaxCap(){
        return this.trayMax;
    }
    public int getSize(){
        return burgerTray.size();
    }

}//class