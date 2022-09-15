package algorithmization.arrays_sort;

/*
Пусть даны две неубывающие последовательности действительных чисел. Требуется
указать те места, на которые нужно вставить элементы 2 последовательности в 1,
так, чтобы новая последовательность оставалась возрастающей.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размеры массивов: ");
            int len1 = in.nextInt();
            int len2 = in.nextInt();

            int[] first = initSortArray(len1);
            int[] second = initSortArray(len2);

            System.out.println("Первый массив: ");
            System.out.println(Arrays.toString(first));

            System.out.println("Второй массив: ");
            System.out.println(Arrays.toString(second));

            showIndexes(first, second);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        if (target <= arr[start]) return start;
        if (target >= arr[end]) return end + 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= arr[mid] && target <= arr[mid + 1]) {
                return mid + 1;
            }
            if (arr[mid] < target) start = mid;
            else end = mid;
        }
        return -1;
    }

    public static int[] initSortArray(int len) {
        if (len <= 0) throw new IllegalArgumentException("Некорректный размер массива.");

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 - 50);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void showIndexes(int[] first, int[] second) {
        for (int i = 0; i < second.length; i++) {
            int index = binarySearch(first, second[i]);
            System.out.print("Индекс для числа " + second[i] + " = " + index + ", ");
        }
    }
}