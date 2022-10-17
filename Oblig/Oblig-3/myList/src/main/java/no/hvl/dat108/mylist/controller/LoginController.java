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
@RequestMapping("${app.url.login}")
public class LoginController{
    @Value("${app.url.invalidpublicpassword}") String INVALID_PUBLIC_PASSWORD_MESSAGE;
    @Value("${app.url.login}") String LOGIN;
    @Value("${app.url.list}") String LIST;

    private final PasswordValidator pv = new PasswordValidator();

    @GetMapping
    public String getLoginVeiw(Model model){
        model.addAttribute("login", "Please enter password");
        return LOGIN;
    }

    @PostMapping
    public String getRequestLogin(@RequestParam String password, @RequestParam String user, HttpServletRequest request, RedirectAttributes ra){
        password = request.getParameter("password");

        if(!pv.isValid(password)){
            ra.addFlashAttribute("invalid", INVALID_PUBLIC_PASSWORD_MESSAGE);
            return "redirect:" + LOGIN;
        }
        Login.userLogIn(request, password, user);

        return "redirect:" + LIST;

    }
}
