package no.hvl.dat108.task2.dataobjects;

import no.hvl.dat108.task2.adt.Queue;

public class HamburgerTray{
    Queue<Hamburger> burgerTray;
    private int trayMax;
    public HamburgerTray(Queue<Hamburger> tray){
        this.burgerTray = tray;
    }

    public synchronized void add(Hamburger burger){

//        if(burgerTray.size() < trayMax){
        burgerTray.enQueue(burger);
        System.out.println("" + burger.getName());
        System.out.println(burgerTray.size());

//        }else{//           System.out.println("The tray is full"); // senere legg stop
//        }
    }
    public synchronized Hamburger remove(){
        //if(!burgerTray.isEmpty()){
        return burgerTray.deQueue();
        //}
        //else{
        //System.out.println("The tray is empty");
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