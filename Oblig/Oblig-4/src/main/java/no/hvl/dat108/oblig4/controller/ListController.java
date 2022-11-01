package no.hvl.dat108.oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/participants")
public class ListController {

    @GetMapping
    public String list(){
        return "participants";
    }

    @PostMapping
    public String logout(){


        return "";
    }
}
