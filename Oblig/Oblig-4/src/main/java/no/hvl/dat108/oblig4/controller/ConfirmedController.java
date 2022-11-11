package no.hvl.dat108.oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/confirmed")
public class ConfirmedController {

    @GetMapping
    public String pageView(){
        return "confirmed";
    }

    @PostMapping
    public String returnLogin(){
        return "redirect:" + "participants";
    }
}
