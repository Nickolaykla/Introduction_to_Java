package algorithmization.decomposition;

import java.util.Arrays;
import java.util.Scanner;

/*
Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] + D[5] + D[6].
Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива с
номерами от k до m.
* */
public class Task8 {
    public static void main(String[] args) {
        int[] arr = initArray();
        System.out.println("Изначальный массив: ");
        System.out.println(Arrays.toString(arr));

        int sum = getTripleSum(arr, 1, 3);
        System.out.println("Сумма = " + sum);
    }

    public static int get3ElemsSum(int[] arr, int k) {
        return arr[k-1] + arr[k] + arr[k+1];
    }

    public static int getTripleSum(int[] arr, int k, int m) {
        if (k < 0 || m > arr.length) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (int i = k; i <= m-2; i++) {
            sum += get3ElemsSum(arr, i);
        }
        return sum;
    }

    public static int[] initArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размер массива: ");
            int len = in.nextInt();
            if (len < 1) {
                System.out.println("Неверная длина массива");
                throw new IllegalArgumentException();
            }
            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 - 50);
            }
            return arr;
        }
    }
}
