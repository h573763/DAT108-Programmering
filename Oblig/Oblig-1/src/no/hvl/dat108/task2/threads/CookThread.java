package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Cook;
import no.hvl.dat108.task2.dataobjects.Hamburger;

import java.util.Random;

public class CookThread extends Thread {
    private Queue<Hamburger> burgerQueue;
    private Hamburger hamburger;
    private Random random;
    private Cook cook;

    public CookThread(Queue<Hamburger> hamburgerQueue, Cook cook) {
        this.burgerQueue = hamburgerQueue;
        this.cook = cook;
        random = new Random();
    }

    @Override
    public void run() {
        System.out.println("(Cook) " + cook.getName() + " is started");
        //I sync med andre kokke råder
        synchronized (cook) {
            //evig løkke
            while (true) {
                if (burgerQueue.size() < burgerQueue.getLim()) {
                    hamburger = new Hamburger();
                    //legger til en burger dersom det er plass
                    cook.makeOrder(hamburger);
                    //vekker opp alle ventende tråder
                    cook.notifyAll();
                    try {
                        //sleeps etter å ha lagt til en burger
                        Thread.sleep(random.nextInt(2000, 5000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //dersom tray er full
                } else {
                    try {
                        System.out.println("The tray is full, " + cook.getName() + " is waiting");
                        //Venter til det er plass i køen
                        cook.wait(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                cook.notifyAll();
            }
        }
    }
}//class