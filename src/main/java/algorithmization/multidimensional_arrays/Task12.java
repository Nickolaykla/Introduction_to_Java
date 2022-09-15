package algorithmization.multidimensional_arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Отсортировать строки матрицы по возрастанию и убыванию значений элементов
*/
public class Task12 {
    public static void main(String[] args) {
        int[][] arr = initialArray();

        System.out.println("Исходная матрица: ");
        printArray(arr);
        System.out.println();

        System.out.println("Строки отсортированы по возрастанию: ");
        naturalOrderSortLines(arr);
        System.out.println();

        System.out.println("По убыванию: ");
        reverseOrderSortLines(arr);
    }

    // Создание матрицы и заполнение случайными значениями
    public static int[][] initialArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размерность матрицы: ");
            int n = in.nextInt();
            int k = in.nextInt();
            if (n <= 0 || k <= 0) {
                throw new IllegalArgumentException("Некорректный размер матрицы");
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

    // Сортировка строк по возрастанию
    public static void naturalOrderSortLines(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
        }
        printArray(arr);
    }

    // Сортировка строк в обратном порядке
    public static void reverseOrderSortLines(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(arr[i])
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
        printArray(arr);
    }

    // Вывод изначальной матрицы
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}