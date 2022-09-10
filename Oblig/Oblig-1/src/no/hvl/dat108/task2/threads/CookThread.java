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

        //ender etter at hver kokk har laget ti burgere hver
        while (true) {
            if (burgerQueue.size() < burgerQueue.getLim()) {
                hamburger = new Hamburger();
                //I sync med queue i ThreadController
                synchronized (ThreadController.queue) {
                    //legger til en burger dersom det er plass
                    cook.makeOrder(hamburger);
                    //vekker opp alle ventende tråder
                    ThreadController.queue.notifyAll();
                }
                try {
                    //sleeps etter å ha lagt til en burger
                    Thread.sleep(random.nextInt(2000, 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }//dersom tray er full
            } else {
                try {
                    System.out.println("The tray is full, " + cook.getName() + " is waiting");
                    synchronized (ThreadController.queue) {
                        //Venter til det er plass i køen
                        ThreadController.queue.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}//class