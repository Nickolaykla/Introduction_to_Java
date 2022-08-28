package algorithmization.multidimensional_arrays;

import java.util.Scanner;

/* Сформировать квадратную матрицу порядка n по заданному образцу (n-четное):
        1   1   1 ... 1 1 1
        2   2   2 ... 2 2 0
        3   3   3 ... 3 0 0
        ...................
        n-1 n-1 0 ... 0 0 0
        n   0   0 ... 0 0 0
* */

public class Task5 {
    public static void main(String[] args) {
        printInitialArray(initArray());
    }
    // выводим созданный массив
    public static void printInitialArray(int[][] arr) {
        System.out.println("Итоговый массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    // Создаем и заполняем массив значениями
    public static int[][] initArray() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите количество строк, столбцов: ");
            int n = in.nextInt();

            if (n <= 0 || n % 2 != 0) throw new IllegalArgumentException();

            int[][] arr = new int[n][n];
            int number = 1;
            int len = arr.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < len; j++) {
                    arr[i][j] = number;
                }
                number++;
                len--;
            }
            return arr;
        }
    }
}
