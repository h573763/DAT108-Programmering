package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/participants")
public class ListController {

    @Autowired private PartyService ps;

    @GetMapping
    public String list(){
        return "participants";
    }

    @PostMapping
    public String logout(){


        return "login";
    }
}
