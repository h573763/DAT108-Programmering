package no.hvl.dat108.task1;

public class Main extends Thread{


    public static void main(String[] args) {

        Thread input = new Thread("Input Thread"){
            @Override
            public void run(){
                
            }
        };input.start();

        Thread output = new Thread("Output Thread"){
            @Override
            public void run(){

            }
        };output.start();
    }


}
