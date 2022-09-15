package algorithmization.decomposition;

import java.util.Arrays;
import java.util.Scanner;

/*
Даны натуральные числа K и N. Написать метод(методы) формирования массива А,
элементами которого являются числа, сумма цифр которых равна К и которые не больше N.
*/
public class Task12 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите 2 числа:");
            int K = in.nextInt();
            int N = in.nextInt();
            if (K < 1 || N < 1) throw new IllegalArgumentException();

            System.out.println(Arrays.toString(initResultArray(K, N)));
        }
    }

    public static int[] initResultArray(int K, int N) {
        int[] arr = new int[N];

        int resArrLen = 0;
        for (; N > 0; N--) {
            if(getDigitsSum(N) == K) {
                arr[resArrLen] = N;
                resArrLen++;
            }
        }
        int[] result = new int[resArrLen];
        System.arraycopy(arr, 0, result, 0, resArrLen);
        return result;
    }

    public static int getDigitsSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}