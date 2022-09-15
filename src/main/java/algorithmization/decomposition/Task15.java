package algorithmization.decomposition;

import java.util.Scanner;

/*
Найти все натуральные n-значные числа, цифры в которых образуют строго
возрастающую последовательность (например, 1234, 5789).
*/
public class Task15 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Выберите количество цифр:");
            int n = in.nextInt();
            if (n < 2 || n > 9) throw new IllegalArgumentException();

            findNumbers(n);
        }
    }
    // проверяет цифры в числе на возрастание
    public static boolean isDigitsIncrease(int num) {
        int digit;
        int tempDigit = 10;
        while (num > 0) {
            digit = num % 10;
            num /= 10;
            if (digit < tempDigit) {
                tempDigit = digit;
            } else return false;
        }
        return true;
    }
    // ищет и печатает числа в заданном диапазоне
    public static void findNumbers(int n) {
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (isDigitsIncrease(i))
                System.out.println(i);
        }
    }
}