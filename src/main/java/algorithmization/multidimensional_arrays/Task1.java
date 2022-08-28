package algorithmization.multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
 Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент
 больше последнего.
*/

public class Task1 {
    public static void main(String[] args) {
        getStart();
    }

    public static void printInitialArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void getStart() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите число столбцов: ");
            int n = in.nextInt();
            if (n < 1) return;
            System.out.println("Введите число строк");
            int k = in.nextInt();
            if (k < 1) return;

            int[][] arr = new int[k][n];
            System.out.println("Заполните массив данными: ");
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            System.out.println("Исходный массив");
            printInitialArray(arr);

            System.out.println("Нечетные столбцы, где 1 элемент > последнего: ");
            printOddColumns(arr);
        }
    }

    public static void printOddColumns(int[][] arr) {
        boolean[] checkColumn = new boolean[arr[0].length];

        for (int i = 0; i < arr[0].length; i += 2) {
            if (arr[0][i] > arr[arr.length - 1][i]) {
                checkColumn[i] = true;
            }
        }

        for (int[] ar : arr) {
            for (int j = 0; j < ar.length; j++) {
                if (checkColumn[j]) {
                    System.out.print(ar[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
