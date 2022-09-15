package algorithmization.decomposition;

import java.util.Scanner;

/*
Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр
*/
public class Task11 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите 2 числа:");
            long num1 = in.nextLong();
            long num2 = in.nextLong();

            checkDigitsCount(num1, num2);
        }
    }

    public static int getDigitsCount(long num1) {
        int count = 0;
        while (num1 != 0) {
            num1 /= 10;
            count++;
        }
        return count;
    }

    public static void checkDigitsCount(long num1, long num2) {
        if (getDigitsCount(num1) > getDigitsCount(num2)) {
            System.out.println("Количество цифр в числе " + num1 + " больше, чем в числе " + num2);
        } else if (getDigitsCount(num1) < getDigitsCount(num2)) {
            System.out.println("Количество цифр в числе " + num2 + " больше, чем в числе " + num1);
        } else System.out.println("Количество цифр равное.");
    }
}