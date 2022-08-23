package no.hvl.dat108;

public class Main extends Thread{


    public static void main(String[] args) {
        System.out.println("This is not a thread");

        //Starting 10 Threads
        for(int i = 0; i < 10; i++){
            //Thread start
            new Thread("Thread: " + i){
                public void run(){
                    System.out.println("This is ran from " + Thread.currentThread().getName());
                    try{
                        //Thread is set to sleep
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        //In the case of an emergency
                        System.out.println(e.getMessage());
                    }
                    System.out.println("End of " + Thread.currentThread().getName());
                }
            }.start();
            //Thread end

        //hey dette er en skikkelig kul test.
        }
        System.out.println(add(2, 5));
        //Call outside the threads
        System.out.println("this is also outside the thread");

    }
    private static int add(int a, int b){
        return a + b;
    }
}
