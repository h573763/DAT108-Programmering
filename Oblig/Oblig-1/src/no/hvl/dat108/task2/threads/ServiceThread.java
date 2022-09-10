package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.Service;

import java.util.Random;

public class ServiceThread extends Thread {
    public Queue<Hamburger> burgerQueue;
    public Service service;
    private final Random random;

    public ServiceThread(Queue<Hamburger> burgerQueue, Service service) {
        this.burgerQueue = burgerQueue;
        this.service = service;
        random = new Random();
    }

    @Override
    public void run() {
        System.out.println("(Server)" + service.getName() + " is started");

        while (true) {
            //så lenge køen ikke er tom
            if (!(burgerQueue.isEmpty())) {
                //I sync med queue i ThreadController
                synchronized (ThreadController.queue) {
                    //ta det øverste elementet i køen
                    service.deliver(burgerQueue.first());
                    //Vekker alle ventede tråder
                    ThreadController.queue.notifyAll();
                }
                try {
                    //sleeps etter å ha lagt til en burger
                    Thread.sleep(random.nextInt(2000, 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }//dersom køen er tom
            else {
                try {
                    System.out.println("The tray is empty, " + service.getName() + " is waiting");
                    //I sync med andre servitør tråder
                    synchronized (ThreadController.queue) {
                        //venter til det er elementer i køen
                        ThreadController.queue.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}//class