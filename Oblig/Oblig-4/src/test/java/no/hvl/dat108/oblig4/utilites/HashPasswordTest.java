package no.hvl.dat108.oblig4.utilites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class HashPasswordTest {

    @Test
    void HashTest() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String password_1 = "vv08x";
        String password_2 = "hakkebakkeskogen";
        String password_3 = "he45tre";

        String salt_1 = "ADFGE5KL";
        String salt_2 = "PORlTRE4";


        String hash_1 = HashPassword.hash(password_1, salt_1);
        String hash_2 = HashPassword.hash(password_2, salt_1);
        String hash_3 = HashPassword.hash(password_3, salt_2);

        assertEquals("6660B0B2AB1F22184CA1FB1630942422F79926FBAD4054B2846BED9451FC2A45", hash_1);
        assertEquals("C71943532D7E1CC4433EECB8874D497FFC2F150BCF51E0B97D05524F794DC30C", hash_2);
        assertNotEquals("1234", hash_3);

    }
}