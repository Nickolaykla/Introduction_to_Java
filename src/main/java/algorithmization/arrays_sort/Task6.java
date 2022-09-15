package algorithmization.arrays_sort;

import java.util.Arrays;
import java.util.Scanner;

/*
Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
Делается это следующим образом: сравниваются два соседних элемента а_i и a_i+1. Если а_i < a_i+1,
то продвигаются на один элемент вперед. Если а_i > a_i+1, то производится перестановка и сдвигаются
на один элемент назад. Составить алгоритм этой сортировки.
*/

public class Task6 {
    public static void main(String[] args) {
        int[] arr = initArray();
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));

        shellSort(arr);
        System.out.println("Результат:");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] initArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите длину массива: ");
            int len = in.nextInt();
            if (len <= 0) throw new IllegalArgumentException();

            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 - 50);
            }
            return arr;
        }
    }

    public static void shellSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                if (i > 0) {
                    i--;
                }
            } else i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
