package algorithmization.multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
Сформировать квадратную матрицу порядка n по заданному образцу (n-четное):
        1 1 1 ... 1 1 1
        0 1 1 ... 1 1 0
        0 0 1 ... 1 0 0
        ...............
        0 1 1 ... 1 1 0
        1 1 1 ... 1 1 1
*/
public class Task6 {
    public static void main(String[] args) {
        printInitialArray(initArray());
    }

    // выводим созданный массив
    public static void printInitialArray(int[][] arr) {
        System.out.println("Итоговый массив: ");
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Создаем и заполняем массив значениями
    public static int[][] initArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите количество строк, столбцов: ");
            int n = in.nextInt();

            if (n <= 0 || n % 2 != 0) throw new IllegalArgumentException("Некорректная размерность матрицы.");

            int[][] arr = new int[n][n];
            int number = 1;
            int len = arr.length;
            int start = 0;
            for (int i = 1; i < n; i++) {
                for (int j = start; j < len; j++) {
                    arr[i][j] = number;
                }
                if (i < n / 2) {
                    len--;
                    start++;
                } else {
                    len++;
                    start--;
                }
            }
            return arr;
        }
    }
}