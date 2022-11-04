package no.hvl.dat108.oblig4.utilites;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    PartyService ps;

    public boolean isValid(String password, String phonenumber){
        int number = Integer.parseInt(phonenumber);
        for(Person person : ps.findAllParticipants()){
            if(person.getPhonenumber() == number){
                return person.getPassword().equals(password);
            }
        }
        return false;
    }
}
