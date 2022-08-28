package algorithmization.multidimensional_arrays;

import java.util.Scanner;

// Дана квадратная матрица. Вывести на экран элементы, стоящие по диагонали

public class Task2 {
    public static void main(String[] args) {
        getStart();
    }

    public static void printDiagonalElements(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][i] + " ");
        }
        System.out.println();

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i][arr.length - 1 - i] + " ");
        }
    }

    // Ввод стартовых данных
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

            System.out.println("Результат:");
            printDiagonalElements(arr);

        }
    }

    // Вывод исходного массива
    public static void printInitialArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}