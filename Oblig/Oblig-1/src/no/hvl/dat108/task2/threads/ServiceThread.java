package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.HamburgerTray;
import no.hvl.dat108.task2.dataobjects.Service;

import java.util.Random;

public class ServiceThread extends Thread {
    private Service service;
    private HamburgerTray hamburgerTray;
    private Random rn;

    @Override
    public void run() {
        if (!(hamburgerTray.getSize() == 0)) {
            service.deliver();
            try{
                Thread.sleep(rn.nextInt(2000, 6000));
            }catch (InterruptedException e){
                e.getMessage();
            }
        }
        else {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                }
            }
        if (hamburgerTray.getSize() != 0) {
            Thread.currentThread().notify();
        }
    }
}
