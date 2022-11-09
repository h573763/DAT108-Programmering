package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.service.PartyService;
import no.hvl.dat108.oblig4.utilites.Login;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/participants")
public class ListController {
    private final String LOGINMESSAGE = "Please login";

    @Autowired private PartyService ps;

    @GetMapping
    public String list(Model model, HttpSession session, RedirectAttributes ra, HttpServletRequest request){

        if(Login.isNotLogedIn(session)){
            ra.addFlashAttribute("loginmessage", LOGINMESSAGE);
            return "redirect:" + "login";
        }
        List<Person> participants = ps.findAllParticipants();
        model.addAttribute("participants", participants);
        return "participants";
    }

    @PostMapping
    public String logout(HttpSession session, RedirectAttributes ra){
        Login.userLogOut(session);

        ra.addAttribute("loggedout");
        ra.addFlashAttribute("logout", "You are logged out");

        return "redirect:" + "login";
    }
}
