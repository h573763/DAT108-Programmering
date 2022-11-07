package no.hvl.dat108.oblig4.utilites;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Component
public class Validator {

    @Autowired
    PartyService ps;

    public boolean isValid(String password, String phonenumber) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String hash;

        int number = Integer.parseInt(phonenumber);
        for(Person person : ps.findAllParticipants()){
            if(person.getPhonenumber() == number){
                hash = HashPassword.hash(password, person.getSalt());
                return person.getHash().equals(hash);
            }
        }
        return false;
    }
}
