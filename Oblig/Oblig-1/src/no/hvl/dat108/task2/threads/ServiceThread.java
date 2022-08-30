package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.HamburgerTray;
import no.hvl.dat108.task2.dataobjects.Service;

import java.util.List;
import java.util.Random;

public class ServiceThread extends Thread {
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
}