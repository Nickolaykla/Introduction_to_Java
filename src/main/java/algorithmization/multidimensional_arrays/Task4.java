package algorithmization.multidimensional_arrays;

import java.util.Scanner;
/*
Сформировать квадратную матрицу порядка n по заданному образцу (n - четное)
        1   2   3   ... n
        n  n-1 n-2  ... 1
        1   2   3   ... n
        n  n-1 n-2  ... 1
        .................
        n  n-1 n-2  ... 1
*/
public class Task4 {
    public static void main(String[] args) {
        printInitialArray(initArray());
    }
    public static int[][] initArray() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размерность матрицы:");
            int n = in.nextInt();

            if (n < 2 || n % 2 != 0) throw new IllegalArgumentException("Некорректная размерность матрицы.");

            int[][] arr = new int[n][n];
            int number = 1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if((i % 2) == 0) {
                        arr[i][j] = number++;
                    } else arr[i][j] = --number;
                }
            }
            return arr;
        }
    }
    public static void printInitialArray(int[][] arr) {
        System.out.println("Итоговый массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}