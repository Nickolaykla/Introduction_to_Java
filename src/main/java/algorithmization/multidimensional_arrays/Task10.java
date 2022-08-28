package algorithmization.multidimensional_arrays;

/*
Найти положительные элементы главной диагонали квадратной матрицы
* */

import java.util.Scanner;

public class Task10 {

    public static void main(String[] args) {
        int[][] arr = initialArray();
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.println("Положительные элементы главной диагонали: ");
        findDiagonalPositiveElems(arr);
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

    public static void findDiagonalPositiveElems(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i] > 0) {
                System.out.print(arr[i][i] + " ");
            }
        }
    }
}
