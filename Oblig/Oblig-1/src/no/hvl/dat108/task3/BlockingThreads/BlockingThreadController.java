package no.hvl.dat108.task3.BlockingThreads;

import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task3.BlockingObjects.BlockingCook;
import no.hvl.dat108.task3.BlockingObjects.BlockingService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingThreadController {

    private static List<BlockingCook> cookList = new ArrayList<>();
    private static List<BlockingService> serviceList = new ArrayList<>();

    public static void menu(){
        BlockingQueue<Hamburger> queue = new LinkedBlockingQueue<>(4);
        BlockingCook carl = new BlockingCook("Carl", queue);
        BlockingCook hans = new BlockingCook("Hans", queue);
        BlockingCook maira = new BlockingCook("Maria", queue);

        cookList.add(carl);
        cookList.add(hans);
        cookList.add(maira);

        BlockingService mia = new BlockingService("mia", queue);
        BlockingService henrik = new BlockingService("Henrik", queue);
        BlockingService gudrun = new BlockingService("Grudrun", queue);

        serviceList.add(mia);
        serviceList.add(henrik);
//        serviceList.add(gudrun);

        for(BlockingCook cook : cookList){
            BlockingCookThread cookThread = new BlockingCookThread(queue, cook);
            cookThread.start();
        }
        for(BlockingService service : serviceList){
            BlockingServiceThread serviceThread = new BlockingServiceThread(queue, service);
            serviceThread.start();
        }
    }
}
