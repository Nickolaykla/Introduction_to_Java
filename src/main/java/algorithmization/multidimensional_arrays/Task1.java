package algorithmization.multidimensional_arrays;

import java.util.Scanner;

/*
 Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент
 больше последнего.
*/

public class Task1 {
    public static void main(String[] args) {
        int[][] arr = initialArray();
        printInitialArray(arr);
        printOddColumns(arr);
    }

    // Выводит исходный массив
    public static void printInitialArray(int[][] arr) {
        System.out.println("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    // инициализация массива случайными данными
    public static int[][] initialArray() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите количество строк:");
            int n = in.nextInt();
            System.out.println("Введите количество столбцов: ");
            int k = in.nextInt();
            if (n <= 0 || k <= 0) {
                throw new IllegalArgumentException();
            }
            int[][] arr = new int[n][k];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    arr[i][j] = (int) (Math.random() * 100 - 50);
                }
            }
            return arr;
        }
    }

    // Вывод нечетных колонок, где 1 элемент больше последнего
    public static void printOddColumns(int[][] arr) {
        boolean[] checkColumn = new boolean[arr[0].length];

        for (int i = 0; i < arr[0].length; i += 2) {
            if (arr[0][i] > arr[arr.length - 1][i]) {
                checkColumn[i] = true;
            }
        }
        System.out.println("Результат: ");
        for (int[] ar : arr) {
            for (int j = 0; j < ar.length; j++) {
                if (checkColumn[j]) {
                    System.out.print(ar[j] + "\t\t");
                }
            }
            System.out.println();
        }
    }
}