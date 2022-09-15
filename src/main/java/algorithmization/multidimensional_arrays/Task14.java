package algorithmization.multidimensional_arrays;

/*
Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
единиц равно номеру столбца.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        fillArray();
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void fillArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размерность матрицы: ");
            int n = in.nextInt(); // Строки
            int k = in.nextInt(); // Столбцы
            if (n <= 0 || k <= 0) {
                throw new IllegalArgumentException("Введены некорректные данные");
            }
            int[][] arr = new int[n][k];

            if (k <= n) {
                for (int i = 0; i < k; i++) {
                    int numberOf1 = i + 1;

                    while (numberOf1 != 0) {
                        int index = (int) (Math.random() * n);

                        if (arr[index][i] == 0) {
                            arr[index][i] = 1;
                            numberOf1--;
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    int numberOf1 = i + 1;

                    while (numberOf1 != 0) {
                        int index = (int) (Math.random() * n);
                        if (arr[index][i] == 0) {
                            arr[index][i] = 1;
                            numberOf1--;
                        }
                    }
                }
            }
            System.out.println("Результат: ");
            printArray(arr);
        }
    }
}