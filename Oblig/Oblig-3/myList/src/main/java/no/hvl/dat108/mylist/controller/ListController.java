package no.hvl.dat108.mylist.controller;

import no.hvl.dat108.mylist.util.Login;
import no.hvl.dat108.mylist.util.MyList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("${app.url.list}")
public class ListController {
    @Value("${app.url.loginmessage}") private String LOGIN_MESSAGE;
    @Value("${app.url.list}") String LIST;
    @Value("${app.url.login}") String LOGIN;

    @GetMapping
    public String veiwList(HttpSession session, RedirectAttributes ra){
        if(Login.isNotLogedIn(session)){
            ra.addAttribute("redirectmessage", LOGIN_MESSAGE);
            return "redirect:" + LOGIN;
        }
        return LIST;
    }
    public String addItemToList(String item, MyList list){

        if(list.findItem(item) || item.equals(""))
            return "redirect:" + LIST;

        list.addItem(item);
        printList(list);

        return "redirect:" + LIST;
    }
    public String removeItemFromList(String item, MyList list){

        System.out.println(item);

        if(list.findItem(item))
            list.removeItem(item);

        printList(list);

        return "redirect:" + "list";
    }
    @PostMapping
    public String doPost(@RequestParam(name = "item") String item, HttpServletRequest request, HttpServletResponse response,
                       RedirectAttributes ra, HttpSession session){

        if(Login.isNotLogedIn(session)){
            ra.addFlashAttribute("redirectMessage", LOGIN_MESSAGE);
            return "redirect:" + "login";
        }

        MyList list = (MyList) session.getAttribute("list");


        String button = request.getParameter("button");

        if(button.equals("Add"))
            return addItemToList(item, list);

        return removeItemFromList(item, list);
    }

    private void printList(MyList list){ //For Debugging
        System.out.println("Current content: ");
        System.out.println("--------------------------");

        list.getItems().stream().filter(listItem -> true).forEach(System.out::println);

        System.out.println("--------------------------");
    }
}
