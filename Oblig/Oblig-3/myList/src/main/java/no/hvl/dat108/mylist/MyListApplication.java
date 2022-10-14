package no.hvl.dat108.mylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication

public class MyListApplication {
//    @Value("${app.url.loginmessage}") private String LOGIN_MESSAGE;

    public static void main(String[] args) {
        SpringApplication.run(MyListApplication.class, args);
    }


}
