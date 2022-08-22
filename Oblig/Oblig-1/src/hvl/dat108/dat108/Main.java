package hvl.dat108.dat108;

public class Main extends Thread{


    public static void main(String[] args) {
        System.out.println("This is not a thread");


        for(int i = 0; i < 10; i++){
            new Main().start();
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }

        System.out.println("this is also outside the thread");

    }

    @Override
    public void run(){
            System.out.println("This is called in thread " + Thread.currentThread().getName());

    }
}
