package no.hvl.dat108.mylist.controller;

import no.hvl.dat108.mylist.util.Login;
import no.hvl.dat108.mylist.util.PasswordValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/${app.url.login}")
public class LoginController {
    @Value("${app.url.invalidpublicpassword}") String INVALID_PUBLICPASSWORD_MESSAGE;
    private PasswordValidator pv = new PasswordValidator();

    @GetMapping(value = "/WEB-INF/jsp/loginview")
    public String getLoginVeiw(){
        return "loginview.jsp";
    }

    @PostMapping
    public String tryLogIn(@RequestParam String password, HttpServletRequest request, RedirectAttributes ra){

        if(!pv.isValid(password)){
            ra.addFlashAttribute("redirectMessage", INVALID_PUBLICPASSWORD_MESSAGE);
                return "redirect:" + "loginview.jsp";
            }
        Login.userLogIn(request, password);

        return "redirect" + "listView.jsp";
    }
}
