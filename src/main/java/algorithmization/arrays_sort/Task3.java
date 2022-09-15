package algorithmization.arrays_sort;

/*
Сортировка выбором. Дана последовательность чисел. Требуется переставить элементы так,
чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
элемент и ставится на первое место, а первый - на место наибольшего. Затем начиная со второго, эта процедура
повторяется. Написать алгоритм сортировки выбором.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int[] arr = initArray();
        System.out.println(Arrays.toString(arr));

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxEl = arr[i];
            int maxInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (maxEl < arr[j]) {
                    maxEl = arr[j];
                    maxInd = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxInd];
            arr[maxInd] = temp;
        }
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
}