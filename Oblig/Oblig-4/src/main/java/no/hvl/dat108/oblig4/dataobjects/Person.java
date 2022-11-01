package no.hvl.dat108.oblig4.dataobjects;

import javax.persistence.*;

public class Person {
    private Long id;

    private String firstName, Lastname;
    private int phonenumber;
    private Gender gender;

    public Person() { //Default
    }

    public Person(Long id, String firstName, String lastname, int phonenumber, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        Lastname = lastname;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public Gender getGender() {
        return gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
