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
        Service mia = new Service("Mia", burgerQueue);

        serviceList.add(henrik);
        serviceList.add(joachim);
        serviceList.add(mia);

        cookList.add(anna);
        cookList.add(carl);
        cookList.add(chris);

        for (Cook cooks : cookList) {
            CookThread cookThread = new CookThread(burgerQueue, cooks);
            cookThread.start();
        }
        for (Service service : serviceList) {
            ServiceThread serviceThread = new ServiceThread(burgerQueue, service);
            serviceThread.start();
        }
    }
}