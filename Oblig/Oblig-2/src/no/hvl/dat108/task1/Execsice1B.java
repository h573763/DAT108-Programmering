package no.hvl.dat108.task1;

import no.hvl.dat108.task3.Main;

import java.util.function.BiFunction;
import java.util.function.IntConsumer;

public class Execsice1B {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> summerfunksjon = (integer1, integer2) -> integer1 + integer2;
        BiFunction<Integer, Integer, Integer> highestNum = ((integer, integer2) -> {
            if (integer2 <= integer)
                return integer;
            else
                return integer2;
        });
        BiFunction<Integer, Integer, Integer> abs = ((integer, integer2) -> Math.abs(integer) - Math.abs(integer2));

        int sum = calculate(12, 13, summerfunksjon);
        int findHighest = calculate(-5, 3, highestNum);
        int absolute = calculate(54, 45, abs);
        System.out.println("Summerfunksjon: " + sum);
        System.out.println("Finner høyeste av to tall: " + findHighest);
        System.out.println("Finner absolutt verdien: " + absolute);
    }

    private static int calculate(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }
}
