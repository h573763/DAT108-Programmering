package no.hvl.dat108.task3.BlockingThreads;

import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task3.BlockingObjects.BlockingCook;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BlockingCookThread extends Thread{
    private BlockingQueue<Hamburger> blockingQueue;
    private Hamburger hamburger;
    private BlockingCook cook;
    private Random random;
    int totalCapacity;
    public BlockingCookThread(BlockingQueue<Hamburger> blockingQueue, BlockingCook cook){
        this.blockingQueue = blockingQueue;
        this.cook = cook;
        random = new Random();
        this.totalCapacity = blockingQueue.remainingCapacity() + blockingQueue.size();

    }
    @Override
    public void run(){
        while (true){
            if ((blockingQueue.size() < this.totalCapacity)) {
                hamburger = new Hamburger();
                //legger til en burger dersom det er plass
                cook.makeOrder(hamburger);
                try{
                    Thread.sleep(random.nextInt(2000, 6000));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
