package no.hvl.dat108.task2.threads;

public class ThreadController {

    // BurgerTray thread.wait til Cook når burgertray er nådd 4
    // Når BurgerTray er nådd mindre enn 4, burger.notify Cook
    //Service blit thread.wait om tray er 0 og thread.nofity hvis ikke
    //
//    public static void menu(){
//
//        for(int i = 0; i < 5; i++){
//            Thread cookThread = new CookThread();
//            cookThread.start();
//        }
//
//        for(int i = 0; i < 5; i++) {
//            Thread serviceThread = new ServiceThread();
//            serviceThread.start();
//        }
//    }
}