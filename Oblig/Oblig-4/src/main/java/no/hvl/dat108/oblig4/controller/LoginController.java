package no.hvl.dat108.oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String viewPage(){
        return "login";
    }

    public String login(@RequestParam(name = "phonenumber") String phone, @RequestParam(name = "password") String password, RedirectAttributes ra){

        if(true){ //TODO: Check if phonenumber and password is correct
            ra.addFlashAttribute("message", "Phonenumber or password is not correct");
            return "redirect:" + "login";
        }

        return "redirect:" + "participants";
    }

    public String signUp(){
        return "signup";
    }

    @PostMapping
    public String doPost(@RequestParam(name = "phonenumber") String phone, @RequestParam(name = "password") String password,
                         RedirectAttributes ra, HttpServletRequest request){

        String button = request.getParameter("button");
        if(button.equals("Login")){
            return login(phone, password, ra);
        }

        return signUp();
    }
}
