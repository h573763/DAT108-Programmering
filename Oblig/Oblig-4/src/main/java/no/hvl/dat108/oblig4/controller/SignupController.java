package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.service.PartyService;
import no.hvl.dat108.oblig4.utilites.HashPassword;
import no.hvl.dat108.oblig4.utilites.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private PartyService ps;

    @GetMapping
    public String viewPage(){
        return "signup";
    }
    @PostMapping
    public String requestSignUp(HttpServletRequest request, RedirectAttributes ra) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        int phone = 0;

        try {
            phone = Integer.parseInt(request.getParameter("phonenumber"));
        }catch (NumberFormatException e){
            ra.addFlashAttribute("invalidnumber", "The phonenumber has to consist of digits only");
            return "redirect:" + "signup";
        }

        int lenght = String.valueOf(phone).length();

        for(Person person : ps.findAllParticipants()){ //Noter at dette ikke er effektivt i en stor database
            if(person.getPhonenumber() == phone){
                ra.addFlashAttribute("existing", "There is already a regisered guest with that number");
                return "redirect:" + "signup";
            }
            if(lenght != 8){//Skjekker lengden på telefonnummeret
                ra.addFlashAttribute("invalidlength", "The phonenumber has to be exaclty 8 digits");
                return "redirect:" + "signup";
            }
        }

        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeted");

        if(!password.equals(repeatedPassword)){
            ra.addFlashAttribute("mismatch", "Passwords has to match");
            return "redirect:" + "signup";
        }

        if(password.length() < 8 || password.length() > 16 ){ //skjekker lenden på passordet
            return  "signup";
        }

        String salt = HashPassword.salt();
        String hash = HashPassword.hash(password, salt);
        String fistName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String gender = request.getParameter("gender");

        Person person = new Person(fistName, lastName, phone, gender, hash, salt);

        ra.addFlashAttribute("newguest", person);

        ps.storeParticipant(person);

        Login.userLogIn(request, password, request.getParameter("phonenumber"));

        return "redirect:" + "confirmed";
    }
}
