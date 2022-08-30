package algorithmization.arrays_sort;

import java.util.Arrays;
import java.util.Scanner;

/*
Сортировка вставками. Место помещения очередного элемента в отсортированную часть производить с помощью
двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
* */
public class Task5 {
    public static void main(String[] args) {
        int[] arr = initArray();
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int binarySearch(int[] arr, int subArrEnd, int target) {
        int start = 0;

        if (target <= arr[start]) {
            return start;
        }
        if (target >= arr[subArrEnd]) {
            return subArrEnd + 1;
        }

        while (start <= subArrEnd) {

            int mid = start + (subArrEnd - start) / 2;

            if (target >= arr[mid] && target <= arr[mid + 1]) {
                return mid + 1;
            }

            if (arr[mid] < target) {
                start = mid;

            } else subArrEnd = mid;
        }
        return -1;
    }

    public static void insertionSort(int[] arr) {
        int index = 0;

        while (index < arr.length && arr[index] < arr[index + 1]) {
            index++;
        }

        for (int i = index + 1; i < arr.length; i++) {
            int insertInd = binarySearch(arr, index, arr[i]);
            int insertVal = arr[i];

            if (i - insertInd >= 0) {
                System.arraycopy(arr, insertInd, arr, insertInd + 1, i - insertInd);
            }
            arr[insertInd] = insertVal;
            index++;
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
