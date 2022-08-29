package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class HamburgerTray{
    Queue<Hamburger> burgerTray;
    private int trayMax;
    public HamburgerTray(Queue<Hamburger> tray){
        this.burgerTray = tray;
    }
    public void add(Hamburger burger){

        if(burgerTray.size() < trayMax){
            burgerTray.enQueue(burger);
            System.out.println("" + burger.getName());
            System.out.println(burgerTray.size());
        }else{
            System.out.println("The tray is full"); // senere legg stop
        }
    }
    public Hamburger remove(){
        if(!burgerTray.isEmpty()){
            return burgerTray.deQueue();
        }
        else{
            System.out.println("The tray is empty");
        }
        return null;
    }
    public void setMaxCap(int cap){
        this.trayMax = cap;
    }
    private int getMaxCap(){
        return this.trayMax;
    }
}//class
