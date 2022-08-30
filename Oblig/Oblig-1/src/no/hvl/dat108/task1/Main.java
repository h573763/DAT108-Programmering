package no.hvl.dat108.task1;
import javax.swing.*;


public class Main extends Thread {
    private static String inString = "";

    public static void main(String[] args) throws InterruptedException{

        String message = "Skriv noe morsomt Skriv quit for å avslutte";
        Thread input = new Thread("Input Thread") {
            @Override
            public void run() {
                while (true) {
                    inString = JOptionPane.showInputDialog(message);
                    if (inString.equals("quit")) {
                        break;
                    }
                }
            }
        };
        input.start();

        Thread output = new Thread("Output Thread") {
            @Override
            public void run() {
                while(true){
                    if(inString.equals("quit")){
                        break;
                    }
                    System.out.println(inString);
                    try {
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }

        };
        output.start();

        input.join();
        output.join();

        System.out.println("Quiting...");

    }
}