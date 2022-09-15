package algorithmization.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Даны целые числа а1, а2... а_n. Вывести на печать только те числа, для которых a_i > i.

public class Task5 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            if (n < 1) throw new IllegalArgumentException("Некорректная длина массива");
            System.out.println("Введите число-ключ: ");
            int i = Integer.parseInt(reader.readLine());

            int[] arr = initArray(n);
            System.out.println("Исходный массив:");
            System.out.println(Arrays.toString(arr));

            function(arr, i);
        }
    }

    public static int[] initArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) - 50;
        }
        return arr;
    }

    public static void function(int[] arr, int i) {
        System.out.println("Числа, которые больше " + i + ":");
        for (int num : arr) {
            if (num > i) System.out.print(num + " ");
        }
    }
}