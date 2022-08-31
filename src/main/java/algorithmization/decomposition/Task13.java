package algorithmization.decomposition;

import java.util.Scanner;

/*
Найти и напечатать все пары "близнецов" из отрезка [n,2n], где n - заданное
натуральное число больше 2. Для решения использовать декомпозицию.
* */
public class Task13 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите число: ");
            int n = in.nextInt();
            if (n <= 2) throw new IllegalArgumentException();

            if (n % 2 != 0) printOddTwins(n);
            else printEvenTwins(n);
        }
    }

    // печатает четные пары
    public static void printEvenTwins(int n) {
        int count = 0;
        for (int i = n; i <= 2 * n; i += 2) {
            count++;
            System.out.print(i + " ");
            if (count % 2 == 0) {
                System.out.println();
                i -= 2;
            }
            if (count > n - 1) break;
        }
    }

    // нечетные
    public static void printOddTwins(int n) {
        int count = 0;
        for (int i = n; i <= 2 * n; i += 2) {
            count++;
            System.out.print(i + " ");
            if (count % 2 == 0) {
                System.out.println();
                i -= 2;
            }
            if (count > n - 2) break;
        }
    }
}
