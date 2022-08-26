package algorithmization.arrays;

/* В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся
число. Если таких чисел несколько, то определить наименьшее из них.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            if (n < 1) return;

            int[] arr = new int[n];

            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(reader.readLine());
            }
            System.out.println(getNumberWithBigFrequency(arr));
        }
    }
    public static int getNumberWithBigFrequency(int[] arr) {
        Arrays.sort(arr);
        int minNum = 0;
        int maxCounts = 0;

        int[] counts = new int[arr.length];

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
