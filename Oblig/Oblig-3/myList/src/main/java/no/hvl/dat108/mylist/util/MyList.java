package no.hvl.dat108.mylist.util;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private List<String> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public void addItem(String item){
        list.add(item);
    }
    public boolean findItem(String item){
        return list.contains(item);
    }
    public void removeItem(String item){
        list.remove(item);
    }
    public List<String> getItems(){
        return this.list;
    }
}
