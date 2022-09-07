package no.hvl.dat108.task3.BlockingObjects;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Cook;
import no.hvl.dat108.task2.dataobjects.Hamburger;

import java.util.concurrent.BlockingQueue;

public class BlockingCook extends Cook {
    private BlockingQueue<Hamburger> blockingQueue;

    public BlockingCook(String name, BlockingQueue<Hamburger> blockingQueue){
        super(name);
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void makeOrder(Hamburger hamburger){
        try {
            blockingQueue.put(hamburger);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Cook " + super.getName() + " is adding burger: " + hamburger.getId() + " traycount: " + blockingQueue.size());
    }
}
