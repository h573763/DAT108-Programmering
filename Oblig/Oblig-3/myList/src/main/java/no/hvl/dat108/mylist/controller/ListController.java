package no.hvl.dat108.mylist.controller;

import no.hvl.dat108.mylist.util.Login;
import no.hvl.dat108.mylist.util.MyList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("list")
public class ListController {
    @Value
   ("${app.url.loginmessage}") private String LOGIN_MESSAGE;

    @GetMapping(value = "/mylist")
    public String veiwList(HttpSession session, RedirectAttributes ra){
        if(Login.isNotLogedIn(session)){
            ra.addFlashAttribute("redirectMessage", LOGIN_MESSAGE);
            return "redirect:" + "login.jsp";
        }
        return "list.jsp";
    }
    @PostMapping
    public String addItemToList(@ModelAttribute("item") String item,
                                HttpSession session, RedirectAttributes ra){
        if(Login.isNotLogedIn(session)){
            ra.addFlashAttribute("redirectMessage", LOGIN_MESSAGE);
            return "login.jsp";
        }

        MyList list = (MyList) session.getAttribute("list");

        if(!list.findItem(item))
            list.addItem(item);

        return "redirect:" + "list.jsp";
    }
    @PostMapping
    public String removeItemFromList(@RequestParam(name="item") String item,
                                     HttpSession session, RedirectAttributes ra){

        if(Login.isNotLogedIn(session)){
            ra.addFlashAttribute("redirectMessage", LOGIN_MESSAGE);
            return "redirect:" + "login.jsp";
        }

        MyList list = (MyList) session.getAttribute("list");

        if(list.findItem(item))
            list.removeItem(item);

        return "redirect:" + "list";
    }
}
