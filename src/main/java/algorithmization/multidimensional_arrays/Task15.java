package algorithmization.multidimensional_arrays;

/*
Найдите наибольший элемент матрицы и замените все нечетные элементы на него.
* */

import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        int[][] arr = initialArray();
        System.out.println("Исходный массив: ");
        printArray(arr);

        System.out.println();
        changeOddElemsToMax(arr);
    }
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
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
    public static void changeOddElemsToMax(int[][] arr) {
        // Находим наибольший элемент в матрице
        int maxElem = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > maxElem) maxElem = arr[i][j];
            }
        }
        // Заменяем нечетные элементы на наибольший элемент
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 != 0) {
                    arr[i][j] = maxElem;
                }
            }
        }
        System.out.println("Максимальный элемент = " + maxElem);
        printArray(arr);
    }
}
