package no.hvl.dat108.oblig4.dataobjects;

import javax.persistence.*;

@Entity
@Table(schema = "dat108")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName, lastname;

    @Column(unique = true)
    private int phonenumber;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String password;

    public Person() { //Default
    }

    public Person(int id, String firstName, String lastname, int phonenumber, Gender gender, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return String.format("firstname= %s, lastname= %s, phonenumber= %d, gender= %s", firstName, lastname, phonenumber, gender);
    }
}
