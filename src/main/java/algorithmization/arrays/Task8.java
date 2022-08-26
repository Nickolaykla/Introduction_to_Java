package algorithmization.arrays;

/* Дана последовательность целых чисел а1, а2...а_n. Образовать новую последовательность,
выбросив из старой те члены, которые равны min(a1,a2...a_n).
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task8 {
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

            System.out.println("Изначальный массив: ");
            System.out.println(Arrays.toString(arr));

            System.out.println("Измененный массив: ");
            System.out.println(Arrays.toString(doNewArr(arr)));
        }
    }
    // находим минимальный элемент
    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int[] doNewArr(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {         // Узнаем новый размер массива
            if (arr[i] == min(arr)) {
                len--;
            }
        }

        // Создаем и заполняем новый массив
        int[] array = new int[len];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != min(arr)) {
                array[j] = arr[i];
                j++;
            }
        }
        return array;
    }
}
