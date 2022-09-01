package no.hvl.dat108.task2.dataobjects;

import java.util.concurrent.atomic.AtomicInteger;

public class Hamburger {
    private String name;
    private static AtomicInteger uniqueId = new AtomicInteger();
    private int id;
    public Hamburger() {
        this.name = "Hamburger";
        this.id = uniqueId.getAndIncrement();
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }
}