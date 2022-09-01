package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.Service;

import java.util.Random;
public class ServiceThread extends Thread {
    private final Queue<Hamburger> burgerQueue;
    private final Service service;
    private final Random random;

    public ServiceThread(Queue<Hamburger> burgerQueue, Service service) {
        this.burgerQueue = burgerQueue;
        this.service = service;
        random = new Random();
    }
    @Override
    public void run() {
        System.out.println("(Server)" + service.getName() + " is started");
        //I sync med andre servitør tråder
        synchronized (service) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //evig løkke
            while (true) {
                //så lenge køen ikke er tom
                if (!(burgerQueue.isEmpty())) {
                    //ta det øverste elementet i køen
                    service.deliver(burgerQueue.first());
                    //Vekker alle ventede tråder
                    service.notifyAll();
                    try {
                        //sleeps etter å ha fjernet en burger
                        Thread.sleep(random.nextInt(2000, 5000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }//dersom køen er tom
                else {
                    try {
                        System.out.println("The tray is empty, " + service.getName() + " is waiting");
                        //venter til det er elementer i køen
                        service.wait(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                service.notifyAll();
            }
        }
    }
}//class