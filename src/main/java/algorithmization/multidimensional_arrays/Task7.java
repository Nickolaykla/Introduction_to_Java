package algorithmization.multidimensional_arrays;

import java.util.Scanner;

/* Сформировать квадратную матрицу порядка N по правилу:
A[I,J] = sin((I^2 - J^2) / N) и подсчитать количество положительных элементов в ней.
* */

public class Task7 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размерность матрицы: ");
            int N = in.nextInt();
            if(N <= 0) return;
            double[][] arr = new double[N][N];

            printArray(arr);
        }
    }
    public static void printArray(double[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] =Math.sin((1.0) * (i * i - j * j) / arr.length);
                if(arr[i][j] > 0) count++;

                System.out.printf("%.2f \t" ,arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("Количество положительных элементов " + count);
    }
}
