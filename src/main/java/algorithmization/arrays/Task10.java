package algorithmization.arrays;

/* Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него
каждый второй элемент(освободившиеся элементы заполнить нулями).
Примечание. Дополнительный массив не использовать.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            if (n < 1) throw new IllegalArgumentException("Введена некорректная длина массива");

            int[] arr = initArray(n);
            System.out.println("Исходный массив:");
            System.out.println(Arrays.toString(arr));

            System.out.println("Результат:");
            trimArray(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[] initArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) - 50;
        }
        return arr;
    }

    public static void trimArray(int[] arr) {
        for (int i = 1; i <= arr.length / 2; i++) {
            arr[i] = 0;
            for (int j = i; j < arr.length - 1; j++) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}