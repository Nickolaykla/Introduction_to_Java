package algorithmization.decomposition;
/*
 Написать методы для нахождения наибольшего общего делителя и наименьшего общего
 кратного двух натуральных чисел.
*/

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите 2 числа: ");
            int k = in.nextInt();
            int n = in.nextInt();
            if (n < 1 || k < 1) return;

            System.out.println("НОД " + k + " и " + n + " = " + gcd(k,n));
            System.out.println("НОК " + k + " и " + n + " = " + lcm(k,n));
        }
    }

    //НОД
    public static long gcd(long num1, long num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }

    //НОК
    public static long lcm(long num1, long num2) {
        return num1 * num2 / gcd(num1, num2);
    }
}
