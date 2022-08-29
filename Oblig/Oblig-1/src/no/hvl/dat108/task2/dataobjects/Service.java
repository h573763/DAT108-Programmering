package no.hvl.dat108.task2.dataobjects;

public class Service {
    private String name;
    private HamburgerTray tray;
    public Service(String name, HamburgerTray tray) {
        this.name = name;
        this.tray = tray;
    }
    public void deliver(){
        tray.remove();
    }
}
