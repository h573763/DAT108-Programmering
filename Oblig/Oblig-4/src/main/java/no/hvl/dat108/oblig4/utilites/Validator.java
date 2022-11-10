package no.hvl.dat108.oblig4.utilites;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.service.PartyService;
import org.hibernate.type.NumericBooleanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
public class Validator {

    @Autowired
    PartyService ps;

    public boolean isValid(String password, String phonenumber) throws UnsupportedEncodingException, NoSuchAlgorithmException {
       return checker(password, phonenumber, ps.findAllParticipants());
    }
    public boolean checker(String password, String phonenumber, List<Person> persons) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        String hash;
        int number = 0;

        try {
            number = Integer.parseInt(phonenumber);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        for(Person person : persons){
            if(person.getPhonenumber() == number){
                hash = HashPassword.hash(password, person.getSalt());
                return person.getHash().equals(hash);
            }
        }
        return false;
    }
}
