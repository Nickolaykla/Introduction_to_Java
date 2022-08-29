package algorithmization.arrays_sort;

/*
Даны 2 неубывающие последовательности. Образовать из них новую.
* */

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        int[] arr1 = IntStream.rangeClosed(1, 10).toArray();
        int[] arr2 = IntStream.rangeClosed(5, 15).toArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] result = new int[len1 + len2];
        System.arraycopy(arr1, 0, result, 0, len1);
        System.arraycopy(arr2, 0, result, len1, len2);

        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }
}
