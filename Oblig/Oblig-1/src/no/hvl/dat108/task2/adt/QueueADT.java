package no.hvl.dat108.task2.adt;

public interface QueueADT<T> {

    void enQueue(T element);
    T deQueue();
    boolean isEmpty();
    int size();
    T first();
}