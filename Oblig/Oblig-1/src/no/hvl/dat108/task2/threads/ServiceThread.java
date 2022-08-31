package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.HamburgerTray;
import no.hvl.dat108.task2.dataobjects.Service;

import java.util.List;
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
        synchronized (service) {
            while (true) {
                if (!(burgerQueue.isEmpty())) {
                    service.deliver(burgerQueue.first());
                    service.notifyAll();
                    try {
                        Thread.sleep(random.nextInt(2000, 5000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        System.out.println("The tray is empty, " + service.getName() + " is waiting");
                        service.wait(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
//    private List<Service> serviceList;
//    private Queue<Hamburger> burgerQueue;
//    private int serverListIndex = 0;
//    private Random rn;
//
////    @Override
//    public void run() {
//        while (true) {
//            serviceList.get(serverListIndex).deliver();
//            if (burgerQueue.size() == 0) {
//                synchronized (this) {
//                    try {
//                        Thread.currentThread().wait();
//                    } catch (InterruptedException e) {
//                        System.out.println(e.getMessage());
//                    }
//                }
//            } else {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.getMessage();
//                }
//            }
//        }
//    }
//        if (hamburgerTray.size() > 0) {
//            service.deliver();
//            try{
//                Thread.sleep(rn.nextInt(2000, 6000));
//            }catch (InterruptedException e){
//                e.getMessage();
//            }
//        }
//        else {
//            synchronized (hamburgerTray) {
//                try {
//                    Thread.currentThread().wait();
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//        if (hamburgerTray.size() == 0) {
//            CookThread.currentThread().notifyAll();
//        }
