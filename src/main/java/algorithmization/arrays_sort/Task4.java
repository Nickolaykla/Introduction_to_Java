package algorithmization.arrays_sort;

import java.util.Arrays;
import java.util.Scanner;

/*
Сортировка обменами
*/
public class Task4 {
    public static void main(String[] args) {
        int[] arr = initArray();
        System.out.println("Изначальный массив: ");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Отсортированный массив: ");
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

    public static void bubbleSort(int[] arr) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i-1]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    needIteration = true;
                }
            }
        }
    }
}