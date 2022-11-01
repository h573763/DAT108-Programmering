package no.hvl.dat108.oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutoDirect {

    @GetMapping("/")
    public String autoDirect(){
        return "login";
    }

}
