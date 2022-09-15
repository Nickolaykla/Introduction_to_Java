package algorithmization.decomposition;

import java.util.Scanner;
// Написать методы для нахождения НОД 4 натуральных чисел
public class Task2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите 4 числа: ");
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int num3 = in.nextInt();
            int num4 = in.nextInt();

            if (num1 < 1 || num2 < 1 || num3 < 1 || num4 < 1) {
                throw new IllegalArgumentException("Числа должны быть натуральными");
            }

            System.out.print("НОД " + num1 + " " + num2 + " " + num3 + " " + num4 + " = ");
            System.out.println(gcd4(num1, num2, num3, num4));
        }
    }

    //НОД
    public static long gcd(long num1, long num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }

    public static long gcd4(long num1, long num2, long num3, long num4) {
        return gcd(gcd(num1, num2), gcd(num3, num4));
    }
}