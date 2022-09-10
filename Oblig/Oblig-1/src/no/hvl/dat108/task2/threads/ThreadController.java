package no.hvl.dat108.task2.threads;

import no.hvl.dat108.task2.adt.Queue;
import no.hvl.dat108.task2.dataobjects.Cook;
import no.hvl.dat108.task2.dataobjects.Hamburger;
import no.hvl.dat108.task2.dataobjects.Service;
import java.util.ArrayList;
import java.util.List;

public class ThreadController {
    private static List<Cook> cookList = new ArrayList<>();
    private static List<Service> serviceList = new ArrayList<>();
    //Denne er global for å kunne brukes som monitor i CookThread og ServiceThread
    static final Queue<Hamburger> queue = new Queue<>(5);

    public static void menu() {

        Cook anna = new Cook("Anna", queue);
        Cook carl = new Cook("Carl", queue);
        Cook chris = new Cook("Chris", queue);

        cookList.add(anna);
        cookList.add(carl);
        cookList.add(chris);

        Service henrik = new Service("Henrik", queue);
        Service joachim = new Service("Joachim", queue);

        serviceList.add(henrik);
        serviceList.add(joachim);

        for (Cook cooks : cookList) {
            CookThread cookThread = new CookThread(queue, cooks);
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            cookThread.start();
        }
        for (Service service : serviceList) {
            ServiceThread serviceThread = new ServiceThread(queue, service);
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            serviceThread.start();
        }
    }
}//class