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
        int count = 0;
        System.out.println("(Server)" + service.getName() + " is started");
        //I sync med andre servitør tråder
        synchronized (service) {
            //Ender etter at hver servitør har servert 10 burgre hver
            while (count <= 5) {
                //så lenge køen ikke er tom
                if (!(burgerQueue.isEmpty())) {
                    //ta det øverste elementet i køen
                    service.deliver(burgerQueue.first());
                    count++;
                    //Vekker alle ventede tråder
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
                        service.notifyAll();
                        service.wait(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
        }
    }
}//class