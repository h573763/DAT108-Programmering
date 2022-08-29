package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Cook;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.HamburgerTray;

import java.util.Random;

public class CookThread extends Thread{
    private Cook cook;
    private HamburgerTray hamburgerTray;
    private Hamburger hamburger;
    private Random random;

    @Override
    public void run(){
        if(hamburgerTray.getSize() < hamburgerTray.getMaxCap()) {
            cook.makeOrder(hamburger);
            try {
                Thread.sleep(random.nextInt(2000, 6000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }else{
            try {
                Thread.currentThread().wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        if(hamburgerTray.getSize() != hamburgerTray.getMaxCap()){
            Thread.currentThread().notify();
        }
    }
}
