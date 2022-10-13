package no.hvl.dat108.mylist.controller;

import no.hvl.dat108.mylist.util.Login;
import no.hvl.dat108.mylist.util.PasswordValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Value("${app.url.invalidpublicpassword}") String INVALID_PUBLIC_PASSWORD_MESSAGE;
    private final PasswordValidator pv = new PasswordValidator();

    @GetMapping("/index")
    public String getLoginVeiw(Model model){
        model.addAttribute("welcome", "Welcome to the login page");
        return "login";
    }

    @PostMapping(value = "/requestlogin")
    public String requestLogIn(@RequestParam(name = "password") String password, HttpServletRequest request, RedirectAttributes ra){

        if(!pv.isValid(password)){
            ra.addFlashAttribute("redirectMessage", INVALID_PUBLIC_PASSWORD_MESSAGE);
                return "login";
            }
        Login.userLogIn(request, password);

        return "list";
    }
}
