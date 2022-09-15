package algorithmization.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/*
В массив А[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
*/

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите размер массива: ");
            int N = Integer.parseInt(reader.readLine());
            System.out.println("Введите число К");
            int K = Integer.parseInt(reader.readLine());
            if (N < 1 || K < 1) {
                throw new IllegalArgumentException("Введены некорректные данные.");
            }

            int[] arr = initArray(N);
            System.out.println("Исходный массив:");
            System.out.println(Arrays.toString(arr));

            System.out.println("Сумма элементов массива, кратных " + K + ":");
            System.out.println(findSum(arr, K));
        }
    }

    public static int[] initArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(20) + 1;
        }
        return arr;
    }

    public static int findSum(int[] arr, int k) {
        int sum = 0;
        for (int num : arr) {
            if ((num % k) == 0) {
                sum += num;
            }
        }
        return sum;
    }
}