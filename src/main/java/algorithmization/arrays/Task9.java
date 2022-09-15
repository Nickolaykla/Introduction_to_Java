package algorithmization.arrays;

/* В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся
число. Если таких чисел несколько, то определить наименьшее из них.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            if (n < 1) throw new IllegalArgumentException("Введена некорректная длина массива");

            int[] arr = initArray(n);
            System.out.println("Исходный массив:");
            System.out.println(Arrays.toString(arr));

            System.out.println(getMinNumberWithBigFrequency(arr));
        }
    }
    public static int[] initArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static int getMinNumberWithBigFrequency(int[] arr) {
        Arrays.sort(arr);
        int minNum = 0;
        int maxCounts = 0;

        int[] counts = new int[arr[arr.length-1] + 1];

        for (int i=0; i < arr.length; i++) {
            counts[arr[i]]++;
            if (maxCounts < counts[arr[i]]) {
                maxCounts = counts[arr[i]];
                minNum = arr[i];
            }
        }
        return minNum;
    }
}