package algorithmization.multidimensional_arrays;

import java.util.Scanner;

/* Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить,
какой столбец содержит максимальную сумму.
* */

public class Task9 {
    public static void main(String[] args) {
        initialArray();
    }

    public static void initialArray() {
        // заполняем массив случайными данными
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
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) (Math.random() * 131);
                }
            }
            // Выводим заполненный массив
            System.out.println("Исходный массив: ");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }

            // Считаем сумму во всех колонках и находим наибольшую
            int sum = 0;
            int tempSum = 0;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    tempSum += arr[j][i];
                }
                System.out.println(i+1 + " колонка = " + tempSum);
                if (tempSum > sum) {
                    sum = tempSum;
                }
                tempSum = 0;
            }
            System.out.println("Наибольшая сумма равна " + sum);
        }
    }
}
