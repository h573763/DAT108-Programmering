package no.hvl.dat108.mylist.util;

import org.springframework.beans.factory.annotation.Value;

public class PasswordValidator {

    private final String PUBLIC_PASSWORD = "vv08x";

    public boolean isValid(String password){
        return password.equals(PUBLIC_PASSWORD);
    }
}
