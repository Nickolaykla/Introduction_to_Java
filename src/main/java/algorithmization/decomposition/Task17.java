package algorithmization.decomposition;

import java.util.Scanner;

/*
Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
Сколько таких действий надо произвести, чтобы получился нуль?
* */
public class Task17 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите число:");
            int n = in.nextInt();
            if (n <= 0) throw new IllegalArgumentException();

            int count = countActions(n);
            System.out.println("Число действий = " + count);
        }
    }
    public static int countActions(int number) {
        int count = 0;
        while ((number > 0)) {
            number -= getSumOfDigits(number);
            count++;
        }

        return count;
    }
    public static int getSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
