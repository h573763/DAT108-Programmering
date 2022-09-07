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

    public static void menu() {

        Queue<Hamburger> burgerQueue = new Queue<>(5);
        Cook anna = new Cook("Anna", burgerQueue);
        Cook carl = new Cook("Carl", burgerQueue);
        Cook chris = new Cook("Chris", burgerQueue);

        Service henrik = new Service("Henrik", burgerQueue);
        Service joachim = new Service("Joachim", burgerQueue);



        serviceList.add(henrik);
        serviceList.add(joachim);

        cookList.add(anna);
        cookList.add(carl);
        cookList.add(chris);

        for (Cook cooks : cookList) {
            CookThread cookThread = new CookThread(burgerQueue, cooks);
            try {
                //Sleeper hver tråd før de starter for å hindre kollisjoner
                Thread.sleep(100);
                cookThread.start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        for (Service service : serviceList) {
            ServiceThread serviceThread = new ServiceThread(burgerQueue, service);
            try {
                //Sleeper hver tråd før de starter for å hindre kollisjoner
                Thread.sleep(100);
                serviceThread.start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}//class