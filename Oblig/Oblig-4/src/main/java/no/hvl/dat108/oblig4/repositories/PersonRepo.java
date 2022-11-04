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

    Person findByPhonenumber(int phonenumber);

    /**
     * To use in the validator class if the phonenumber and password is connected to the same entity
     * @param phonenumber
     * @param password
     * @return The person the phonenumber and password belongs to
     */
}
