package no.hvl.dat108.task2;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.*;
import no.hvl.dat108.task2.threads.CookThread;
import no.hvl.dat108.task2.threads.ServiceThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static List<Cook> cookList = new ArrayList<>();
    private static List<Service> serviceList = new ArrayList<>();
    public static int burgers = 0;
    private static int cookListIndex = 0;
    private static int serverListIndex = 0;

    public static void main(String... blablabla) {

        Queue<Hamburger> burgerQueue = new Queue<>(5);
        Cook anna = new Cook("Anna", burgerQueue);
        Cook carl = new Cook("Carl", burgerQueue);
        Cook chris = new Cook("Chris", burgerQueue);

        Service henrik = new Service("Henrik", burgerQueue);
        Service joachim = new Service("Joachim", burgerQueue);
        Service mia = new Service("Mia", burgerQueue);

        serviceList.add(henrik);
        serviceList.add(joachim);
        serviceList.add(mia);

        cookList.add(anna);
        cookList.add(carl);
        cookList.add(chris);

        for (cookListIndex = 0; cookListIndex < cookList.size() - 1; cookListIndex++) {
            System.out.println(cookList.get(cookListIndex).getName());
            Thread cookthread = new Thread("Cook " + cookListIndex) {
                @Override
                public synchronized void run() {
                    System.out.println(Thread.currentThread().getName() + " is started");
                    Hamburger hamburger = new Hamburger();
                        while (true) {
                            // System.out.println("C1: " + burgerQueue.size());

                            if (burgerQueue.size() < 6) {
                                burgers = burgers + 1;
                                cookList.get(random.nextInt(0, 3)).makeOrder(hamburger);
                            }
                                try {

                                    Thread.sleep(random.nextInt(2000, 6000));
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                        }
                }
            };
            cookthread.start();

        }
        for (serverListIndex = 0; serverListIndex < serviceList.size() - 1; serverListIndex++) {
            Thread serviceThread = new Thread("Server " + serverListIndex) {
                @Override
                public synchronized void run() {
                    System.out.println(Thread.currentThread().getName() + " is started");
                    while (true) {
                        if (burgerQueue.size() > 1) {
                            serviceList.get(random.nextInt(0, 3)).deliver();
                        }
                            try {
                                Thread.sleep(random.nextInt(2000, 6000));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                    }
                }
            };
            serviceThread.start();
        }

    }
}
