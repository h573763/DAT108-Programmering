package no.hvl.dat108.oblig4.utilites;

import no.hvl.dat108.oblig4.dataobjects.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void isValidTest() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String atle_passord = "vv08x";
        String maren_passord = "mm43re";
        String siri_passord = "tre3kre";

        String salt_1 = HashPassword.salt();

        String hash_1 = HashPassword.hash(atle_passord, salt_1);
        String hash_2 = HashPassword.hash(maren_passord, salt_1);
        String hash_3 = HashPassword.hash(siri_passord, salt_1);

        List<Person> persons = Arrays.asList(
                new Person("Alte", "Patle", 41414141, "Male", hash_1, salt_1),
                new Person("Maren", "Sør", 45454545, "Female", hash_2, salt_1),
                new Person("Siri", "Smidig", 46464646, "Female", hash_3, salt_1)
        );

        assertTrue(validator.checker(atle_passord, "41414141", persons));
        assertTrue(validator.checker("mm43re", "45454545", persons));
        assertFalse(validator.checker("123", "46464646", persons));
    }
}
