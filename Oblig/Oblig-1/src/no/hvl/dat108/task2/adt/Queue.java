package no.hvl.dat108.task2.adt;

public class Queue<T> implements QueueADT<T> {
    private int count;
    private int lim;
    private LinearNode<T> head, tail;

    public Queue(int lim){
        this.lim = lim;
        count = 0;
        head = tail = null;
    }
    public Queue(){
        count = 0;
        head = tail = null;
    }
    @Override
    public void enQueue(T element) {
        LinearNode<T> node = new LinearNode<T>(element);

        if(isEmpty())
            head = node;
        else
            tail.setNext(node);

        tail = node;
        count++;
    }
    @Override
    public T deQueue() throws RuntimeException{

        if(isEmpty())
            throw new RuntimeException();
        //throw an exception

        T result = head.getElement();
        head = head.getNext();
        count--;

        if(isEmpty())
            tail = null;

        return result;
    }
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    @Override
    public int size(){
        return count;
    }
    @Override
    public int getLim() {
        return lim;
    }
    @Override
    public T first(){
        return head.getElement();
    }
    @Override
    public boolean isNull(){
        return tail == null;
    }
}//class