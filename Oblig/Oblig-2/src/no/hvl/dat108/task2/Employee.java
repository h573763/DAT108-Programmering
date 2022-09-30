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
    public String getLastName() {
        return lastName;
    }
    public Posistion getPosition() {
        return position;
    }
    public Gender getGender() {
        return gender;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
        return this.firstName + " " + this.lastName + ": " + this.salary;
    }
}
