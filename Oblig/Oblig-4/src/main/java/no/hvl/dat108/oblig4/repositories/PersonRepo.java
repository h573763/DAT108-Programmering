package no.hvl.dat108.oblig4.repositories;

import no.hvl.dat108.oblig4.dataobjects.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    /**
     * To use for the list.jsp
     * @return A list of participants
     */
    List<Person> findAll();

    /**
     *
     * @param phonenumber the unique lookup we use to find persons in the database
     * @return the person that where found, if none is found we return null
     */
    Person findByPhonenumber(int phonenumber);
}
