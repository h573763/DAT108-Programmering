package no.hvl.dat108.oblig4.utilites;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashPassword {
    public static final int SALTLENGTH = 16;
    public static final int ITERATIONS = 1000;

    public static String hash(String password, String salt) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        byte[] passToByte = password.getBytes(StandardCharsets.UTF_8);

        byte[] salt_bytes = salt.getBytes();

        byte[] saltPlussPassord = new byte[salt_bytes.length + passToByte.length];
        System.arraycopy(salt_bytes, 0, saltPlussPassord, 0, salt_bytes.length);
        System.arraycopy(passToByte, 0, saltPlussPassord, salt_bytes.length, passToByte.length);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = saltPlussPassord;
        for (int i = 1; i <= ITERATIONS; i++) {
            digest = md.digest(digest);
        }
        return DatatypeConverter.printHexBinary(digest);
    }

    public static String salt() {

        byte[] salt = new byte[SALTLENGTH];
        new SecureRandom().nextBytes(salt);

        return DatatypeConverter.printHexBinary(salt);
    }
}
