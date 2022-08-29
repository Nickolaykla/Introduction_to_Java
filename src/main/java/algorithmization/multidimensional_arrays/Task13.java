package algorithmization.multidimensional_arrays;

/*
Отсортировать столбцы матрицы по возрастанию и убыванию элементов
* */

import java.util.Arrays;
import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        int[][] arr = initialArray();
        System.out.println("Исходный массив: ");
        printArray(arr);
        System.out.println();

        System.out.println("Колонки отсортированы по возрастанию: ");
        naturalOrderColumnsSort(arr);

        System.out.println("Колонки отсортированы по убыванию: ");
        reverseOrderColumnsSort(arr);
    }
    // Создание матрицы и заполнение случайными значениями
    public static int[][] initialArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размерность матрицы: ");
            int n = in.nextInt();
            int k = in.nextInt();
            if (n <= 0 || k <= 0) {
                System.out.println("Некорректный размер");
                throw new IllegalArgumentException();
            }
            int[][] arr = new int[n][k];

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) (Math.random() * 100 - 50);
                }
            }
            return arr;
        }
    }
    public static void naturalOrderColumnsSort(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                for (int k = 0; k < arr.length - j - 1; k++) {
                    if (arr[k][i] > arr[k + 1][i]) {
                        int temp = arr[k][i];
                        arr[k][i] = arr[k + 1][i];
                        arr[k + 1][i] = temp;
                    }
                }
            }
        }
        printArray(arr);
    }
    public static void reverseOrderColumnsSort(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                for (int k = 0; k < arr.length - j - 1; k++) {
                    if (arr[k][i] < arr[k + 1][i]) {
                        int temp = arr[k][i];
                        arr[k][i] = arr[k + 1][i];
                        arr[k + 1][i] = temp;
                    }
                }
            }
        }
        printArray(arr);
    }
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
