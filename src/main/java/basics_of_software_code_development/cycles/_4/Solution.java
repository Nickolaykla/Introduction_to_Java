package basics_of_software_code_development.cycles._4;

import java.math.BigInteger;

// Составить программу нахождения квадратов первых 200 чисел

public class Solution {
    public static void main(String[] args) {

        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 1; i <= 200; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i * i));
        }

        System.out.println(bigInteger);
    }
}
