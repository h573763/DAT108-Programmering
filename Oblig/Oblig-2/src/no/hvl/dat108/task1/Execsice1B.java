package no.hvl.dat108.task1;

public class Execsice1B {
    public static void main(String[] args) {
        double result = calculate(2, 4, () -> "ADD");
        System.out.println(result);
    }
    private static double calculate(double a, double b, Claculate calculation){
        if(calculation == Calculation.ADD)
            return a + b;
        else if(calculation.equals("MINUS"))
            return a - b;
        else if(calculation.equals("MULTIPY"))
            return a * b;
        else if(calculation.equals("DIVIDE"))
            return a/b;

        return -1;
    }
}

@FunctionalInterface
interface Claculate {
    Calculation calc();
}
