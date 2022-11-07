package no.hvl.dat108.oblig4.utilites;

import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class HashPassword {
    public static final int SALTLENGDE = 16;
    public static final int ITERASJONER = 1000;

    public static String hash(String password, String salt) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        final String ENCODING = "Base64";

        byte[] passToByte = password.getBytes("UTF-8");

        byte[] salt_bytes = salt.getBytes();

        byte[] saltPlussPassord = new byte[salt_bytes.length + passToByte.length];
        System.arraycopy(salt_bytes, 0, saltPlussPassord, 0, salt_bytes.length);
        System.arraycopy(passToByte, 0, saltPlussPassord, salt_bytes.length, passToByte.length);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = saltPlussPassord;
        for (int i = 1; i <= ITERASJONER; i++) {
            digest = md.digest(digest);
        }
        return DatatypeConverter.printHexBinary(digest);
    }

    public static String salt() throws UnsupportedEncodingException, NoSuchAlgorithmException {

        byte[] salt = new byte[SALTLENGDE];
        new SecureRandom().nextBytes(salt);

        return DatatypeConverter.printHexBinary(salt);
    }
}
