package basics_of_software_code_development.cycles;

import java.math.BigInteger;

// Составить программу нахождения квадратов первых 200 чисел

public class Task4 {
    public static void main(String[] args) {

        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 1; i <= 200; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i * i));
        }

        System.out.println(bigInteger);
    }
}