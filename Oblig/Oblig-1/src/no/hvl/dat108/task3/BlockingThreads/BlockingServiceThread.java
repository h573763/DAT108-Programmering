package no.hvl.dat108.task3.BlockingThreads;

import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task3.BlockingObjects.BlockingService;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BlockingServiceThread extends Thread{
    private BlockingQueue<Hamburger> blockingQueue;
    private BlockingService blockingService;
    private Random random;

    public BlockingServiceThread(BlockingQueue<Hamburger> blockingQueue, BlockingService service){
        this.blockingQueue = blockingQueue;
        this.blockingService = service;
        random = new Random();
    }

    @Override
    public void run(){
        while(true){
            if(!(blockingQueue.isEmpty())){
                blockingService.deliver(blockingQueue.peek());
                try{
                    Thread.sleep(random.nextInt(2000, 6000));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
