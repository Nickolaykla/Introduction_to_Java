package algorithmization.multidimensional_arrays;

/*
Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] array = initialArray(); // инициализируем массив
        printInitialArray(array); // выводим начальный массив

        System.out.println("Введите номер строки и колонки: ");
        int line = IN.nextInt();
        int column = IN.nextInt();
        // выводим результат
        printLineAndColumn(array, line, column);
    }

    public static int[][] initialArray() {
        System.out.println("Введите количество строк:");
        int n = IN.nextInt();
        System.out.println("Введите количество столбцов: ");
        int k = IN.nextInt();
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("Введена некорректная размерность матрицы.");
        }
        int[][] arr = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = (int) (Math.random() * 131);
            }
        }
        return arr;
    }

    public static void printInitialArray(int[][] arr) {
        System.out.println("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
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
