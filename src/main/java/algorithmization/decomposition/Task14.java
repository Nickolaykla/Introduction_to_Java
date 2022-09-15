package algorithmization.decomposition;

import java.util.Scanner;

/*
Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная
в степень n, равна самому числу. Найти все числа Армстронга от 1 до k.
*/
public class Task14 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите границу поиска:");
            int k = in.nextInt();
            if (k < 1) throw new IllegalArgumentException();

            getArmNumbers(k);
        }
    }

    public static int getDigit(int num, int n) {
        int digit = 0;
        for (int i = 1; i <= n; i++) {
            digit = num % 10;
            num /= 10;
        }
        return digit;
    }

    public static int getDigitsCount(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static boolean isArmstrongNumber(int number) {
        int sum = 0;
        int digNum = getDigitsCount(number);
        for (int i = 1; i <= digNum; i++) {
            sum += Math.pow(getDigit(number, i), digNum);
        }
        return sum == number;
    }
    public static void getArmNumbers(int k) {
        for (int i = 1; i <= k; i++) {
            if(isArmstrongNumber(i)) System.out.print(i + " ");
        }
    }
}