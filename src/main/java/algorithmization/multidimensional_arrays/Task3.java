package algorithmization.multidimensional_arrays;

/*
Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = initialArray(); // инициализируем массив
        printInitialArray(array); // выводим начальный массив

        // выводим результат
        printLineAndColumn(array, 2, 4);
    }

    public static int[][] initialArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите количество строк:");
            int n = in.nextInt();
            System.out.println("Введите количество столбцов: ");
            int k = in.nextInt();
            if (n <= 0 || k <= 0) {
                throw new IllegalArgumentException();
            }
            int[][] arr = new int[n][k];

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = (int) (Math.random() * 131);
                }
            }
            return arr;
        }
    }

    public static void printInitialArray(int[][] arr) {
        System.out.println("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printLineAndColumn(int[][] arr, int line, int column) {
        System.out.println("Результат: ");
        System.out.println("Строка: ");
        System.out.println(Arrays.toString(arr[line - 1]));

        System.out.println("Колонка:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][column - 1]);
        }
    }
}
