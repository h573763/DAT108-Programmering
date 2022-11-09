package no.hvl.dat108.oblig4.dataobjects;

import javax.persistence.*;

@Entity
@Table(name= "persons", schema = "dat108")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)

    private String lastname;

    @Column(name="phonenumber", unique = true)
    private int phonenumber;


    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="passhash", nullable = false)
    private String hash;

    @Column(name = "salt", nullable = false)
    private String salt;

    public Person() { //Default
    }

    public Person(String firstName, String lastname, int phonenumber, String gender){
        this.firstName = firstName;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }

    public Person(String firstName, String lastname, int phonenumber, String gender, String hash, String salt) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.hash = hash;
        this.salt = salt;
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

    public String getGender() {
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

//    @Override
//    public String toString(){
//        return String.format("firstname= %s, lastname= %s, phonenumber= %d, gender= %s", firstName, lastname, phonenumber, gender);
//    }
}
