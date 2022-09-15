package algorithmization.decomposition;

import java.util.Arrays;
import java.util.Scanner;

/*
Дано натуральное число N. Написать метод(методы) для формирования массива,
элементами которого являются цифры числа N.
*/
public class Task10 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите число:");
            long N = in.nextLong();
            if (N < 1) throw new IllegalArgumentException();

            System.out.println(Arrays.toString(getArray(N)));
        }
    }

    public static char[] getArray(long n) {
        return String.valueOf(n).toCharArray();
    }
}
