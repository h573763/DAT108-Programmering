package no.hvl.dat108.task2;

import java.util.Date;

public class Employee {

    private String name;
    private Date birth;
    private int number;

    public Employee(String name, Date birth, int number) {
        this.name = name;
        this.birth = birth;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public int getNumber() {
        return number;
    }
}
