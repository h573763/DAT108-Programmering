package no.hvl.dat108.mylist.util;

import org.springframework.beans.factory.annotation.Value;

public class PasswordValidator {

    @Value("${app.url.password}") private String PUBLIC_PASSWORD;

    public boolean isValid(String password){
        return password.equals(PUBLIC_PASSWORD);
    }
}
