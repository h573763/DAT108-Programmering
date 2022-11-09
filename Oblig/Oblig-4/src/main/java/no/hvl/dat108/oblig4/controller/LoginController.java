package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.service.PartyService;
import no.hvl.dat108.oblig4.utilites.Login;
import no.hvl.dat108.oblig4.utilites.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public Validator validator;

    @Autowired
    PartyService ps;

    @GetMapping
    public String viewPage(){
        return "login";
    }

    public String login(@RequestParam(name = "number") String phone, @RequestParam(name = "password") String password, RedirectAttributes ra,
                        HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        if(validator.isValid(password, phone)){ //Check if phonenumber and password is correct
            Login.userLogIn(request, password, phone);
            ra.addAttribute("user=" + ps.findByPhonenumber(Integer.parseInt(phone)).getFirstName());
            return "redirect:" + "participants";
        }
        ra.addFlashAttribute("message", "Phonenumber or password is not correct");
        ra.addAttribute("failed+login");
        return "redirect:" + "login";
    }

    public String signUp(){
        return "signup";
    }

    @PostMapping
    public String doPost(@RequestParam(name = "number") String phone, @RequestParam(name = "password") String password,
                         RedirectAttributes ra, HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String button = request.getParameter("button");
        if(button.equals("Login")){
            return login(phone, password, ra, request);
        }

        return signUp();
    }
}
