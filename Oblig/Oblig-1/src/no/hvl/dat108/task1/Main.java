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
        Object lock = new Object();

        for (cookListIndex = 0; cookListIndex < cookList.size() - 1; cookListIndex++) {
            System.out.println(cookList.get(cookListIndex).getName());
            Thread cookthread = new Thread("Cook " + cookListIndex) {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is started");
                    Hamburger hamburger = new Hamburger();
                    synchronized (lock) {
                        while (true) {
                            // System.out.println("C1: " + burgerQueue.size());
                            if(burgerQueue.size() < burgerQueue.getLim()) {
                                cookList.get(random.nextInt(0, 3)).makeOrder(hamburger);
                                lock.notifyAll();
                            }
                            // System.out.print(" C2: " + burgerQueue.size());
                            if (burgerQueue.size() == burgerQueue.getLim()) {
                                try {
                                    System.out.println("Cooks are Waiting!");
                                    lock.notifyAll();
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                try {
                                    //   System.out.println("  Cooks is put to sleep!");
                                    wait();
                                    Thread.sleep(random.nextInt(2000, 6000));
                                } catch (InterruptedException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
            };
            cookthread.start();

        }
        for (serverListIndex = 0; serverListIndex < serviceList.size() - 1; serverListIndex++) {
            Thread serviceThread = new Thread("Server " + serverListIndex) {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is started");
                    synchronized (lock) {
                        while (true) {
                            // System.out.println("S1: " + burgerQueue.size());
                            if(!(burgerQueue.isEmpty())) {
                                serviceList.get(random.nextInt(0, 3)).deliver();
                                lock.notifyAll();
                            }
                            //System.out.print("S2: " + burgerQueue.size());
                            if (burgerQueue.size() == 0) {
                                try {
                                    lock.notifyAll();
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                try {
                                    // System.out.println("Serivce is put to sleep!");
                                    lock.wait();
                                    Thread.sleep(random.nextInt(2000, 6000));
                                } catch (InterruptedException e) {
                                    e.getMessage();
                                }
                            }
                        }
                    }
                }
            };
            serviceThread.start();
        }

    }

}//class


//        for(serverListIndex = 0; serverListIndex < 3; serverListIndex++) {
//            serviceThread.start();
//        }


//            for(int i = 0; i < 3; i++) {
//
//                cookListIndex++;
//            }
//            for(int i = 0; i < 3; i++) {
//
//                serverListIndex++;
//            }

//        Hamburger burger = new Hamburger();
//
//        Service anne = new Service("Anna", burgerTray);
//        Service chad = new Service("Henrik", burgerTray);

//        final int KAPASITET = 4;
//
//        skrivUtHeader(kokker, servitorer, KAPASITET);
//
//        for (String navn : kokker) {
//            new Cook(brett, navn).start();
//        }
//        for (String navn : servitorer) {
//            new Service(brett, navn).start();
//        }
//
//    }
//
//    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {