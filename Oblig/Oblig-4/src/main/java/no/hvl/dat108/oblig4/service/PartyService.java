package no.hvl.dat108.oblig4.service;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

    @Autowired
    private PersonRepo personRepo;

    public List<Person> findAllParticipants(){
        return personRepo.findAll();
    }

    public void storeParticipant(Person person){
        if(person != null) {
            personRepo.save(person);
        }
    }
}
