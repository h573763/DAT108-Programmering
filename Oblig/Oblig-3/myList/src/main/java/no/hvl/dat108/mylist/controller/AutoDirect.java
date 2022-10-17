package no.hvl.dat108.mylist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutoDirect {
    @GetMapping("/")
    public String autodirect(){
        return "login";
    }
}
