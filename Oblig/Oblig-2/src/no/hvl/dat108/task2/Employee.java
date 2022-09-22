package no.hvl.dat108.task2;

import no.hvl.dat108.task2.enums.Gender;
import no.hvl.dat108.task2.enums.Posistion;

public class Employee {

    private String firstName, lastName;
    private Posistion position;
    private Gender gender;
    private double salary;

    public Employee(String firstName, String lastName, Posistion position, Gender gender, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.gender = gender;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Posistion getPosition() {
        return position;
    }

    public void setPosition(Posistion position) {
        this.position = position;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
