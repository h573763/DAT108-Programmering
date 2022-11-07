package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/participants")
public class ListController {

    @Autowired private PartyService ps;

    @GetMapping
    public String list(Model model){

        List<Person> participants = ps.findAllParticipants();
        model.addAttribute("participants", participants);
        return "participants";
    }

    @PostMapping
    public String logout(){


        return "login";
    }
}
