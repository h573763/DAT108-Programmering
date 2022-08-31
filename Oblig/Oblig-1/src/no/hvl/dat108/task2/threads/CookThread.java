package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Cook;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.HamburgerTray;
import no.hvl.dat108.task2.dataobjects.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CookThread extends Thread {
    private Queue<Hamburger> burgerQueue;
    private Hamburger hamburger;
    private Random random;
    private Cook cook;

    public CookThread(Queue<Hamburger> hamburgerQueue, Cook cook){
        this.burgerQueue = hamburgerQueue;
        this.cook = cook;
        random = new Random();
    }

    @Override
    public void run() {
        System.out.println("(Cook) " + cook.getName() + " is started");
        synchronized (cook){
        while (true) {
            // System.out.println("C1: " + burgerQueue.size());
            if (burgerQueue.size() < burgerQueue.getLim()) {
                hamburger = new Hamburger();
                cook.makeOrder(hamburger);
                cook.notifyAll();
                try {
                    Thread.sleep(random.nextInt(2000, 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try{
                    System.out.println("The tray is full, " + cook.getName() + " is waiting" );
                    cook.wait(1000);
                }catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}