package no.hvl.dat108.task3.BlockingObjects;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.Service;

import java.util.concurrent.BlockingQueue;

public class BlockingService extends Service {
    private BlockingQueue<Hamburger> blockingQueue;

    public BlockingService(String name, BlockingQueue<Hamburger> blockingQueue) {
        super(name);
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void deliver(Hamburger burger) {
        try {
            blockingQueue.take();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Server " + super.getName() + " is serving a burger: " + burger.getId() + " traycount: " + blockingQueue.size());
    }
}
