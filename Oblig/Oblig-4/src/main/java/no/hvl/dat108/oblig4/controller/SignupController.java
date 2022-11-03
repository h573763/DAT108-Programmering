package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.dataobjects.Gender;
import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

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
    public String requestSignUp(HttpServletRequest request, RedirectAttributes ra){

        int phone = Integer.parseInt(request.getParameter("phonenumber"));

        int lenght = String.valueOf(phone).length();

        for(Person person : ps.findAllParticipants()){
            if(person.getPhonenumber() == phone){
                ra.addFlashAttribute("existing", "There is already a regisered guest with that number");
                return "redirect:" + "signup";
            }
        }

        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeted");

        if(!password.equals(repeatedPassword)){
            ra.addFlashAttribute("mismatch", "Passwords has to match");
            return "redirect:" + "signup";
        }


        String fistName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        Person person = new Person(fistName, lastName, phone, password);


        String gender = request.getParameter("gender");

        if(gender.equals("Male"))
            person.setGender(Gender.MALE);
        else
            person.setGender(Gender.FEMALE);

        ps.storeParticipant(person);

        return "redirect:" + "confirmed";
    }
}
