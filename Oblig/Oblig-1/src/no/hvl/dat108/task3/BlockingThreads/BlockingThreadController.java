package no.hvl.dat108.task3.BlockingThreads;

import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task3.BlockingObjects.BlockingCook;
import no.hvl.dat108.task3.BlockingObjects.BlockingService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingThreadController {

    private static List<BlockingCook> cookList = new ArrayList<>();
    private static List<BlockingService> serviceList = new ArrayList<>();

    public static void menu(){
        BlockingQueue<Hamburger> queue = new ArrayBlockingQueue<>(3);
        BlockingCook carl = new BlockingCook("Carl", queue);
        BlockingCook hans = new BlockingCook("Hans", queue);
        BlockingCook maira = new BlockingCook("Maria", queue);

        cookList.add(carl);
        cookList.add(hans);
        cookList.add(maira);

        BlockingService mia = new BlockingService("mia", queue);
        BlockingService henrik = new BlockingService("Henrik", queue);

        serviceList.add(mia);
        serviceList.add(henrik);

        for(BlockingCook cook : cookList){
            BlockingCookThread cookThread = new BlockingCookThread(queue, cook);
            try{
                //Vi hindrer at trådene starter nøyaktig samtidig, men med 100 ms sekunder mellomrom
                Thread.sleep(100);
                cookThread.start();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        for(BlockingService service : serviceList){
            BlockingServiceThread serviceThread = new BlockingServiceThread(queue, service);
            try{
                //Vi hindrer at trådene starter nøyaktig samtidig, men med 100 ms sekunder mellomrom
                Thread.sleep(100);
                serviceThread.start();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
