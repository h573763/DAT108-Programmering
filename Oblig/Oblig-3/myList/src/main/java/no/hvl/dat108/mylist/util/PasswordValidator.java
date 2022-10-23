package no.hvl.dat108.mylist.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

public class PasswordValidator {
    private final String PUBLIC_PASSWORD = "vv08x";

    public boolean isValid(String password){
        return password.equals(PUBLIC_PASSWORD);
    }
}
