package algorithmization.multidimensional_arrays;

import java.util.Scanner;

// Дана квадратная матрица. Вывести на экран элементы, стоящие по диагонали

public class Task2 {
    public static void main(String[] args) {
        int[][] arr = initialArray();
        printInitialArray(arr);
        printDiagonalElements(arr);
    }

    public static void printDiagonalElements(int[][] arr) {
        System.out.println("Элементы по диагонали: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][i] + ", ");
        }
        System.out.println();

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i][arr.length - 1 - i] + ", ");
        }
    }

    public static int[][] initialArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размерность матрицы: ");
            int n = in.nextInt();
            if (n <= 0) {
                System.out.println("Некорректный размер");
                throw new IllegalArgumentException();
            }
            int[][] arr = new int[n][n];

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) (Math.random() * 100 - 50);
                }
            }
            return arr;
        }
    }

    // Вывод исходного массива
    public static void printInitialArray(int[][] arr) {
        System.out.println("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("\t" + arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}