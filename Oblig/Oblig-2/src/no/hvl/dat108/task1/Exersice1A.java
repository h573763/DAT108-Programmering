package no.hvl.dat108.task1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exersice1A {

    public static void main(String ... args) {
        List<String> stringList = Arrays.asList("10","1","20", "110", "21", "12");

        Collections.sort(stringList, (a,b) -> Integer.valueOf(a).compareTo(Integer.valueOf(b)));

        System.out.println(stringList);
    }
}
