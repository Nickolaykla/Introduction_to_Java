package algorithmization.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
В массив А[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
*/

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите размер массива: ");
            int N = Integer.parseInt(reader.readLine());
            if (N < 1) {
                System.out.println("Введен некорректный размер массива");
                return;
            }
            int[] arr = new int[N];

            System.out.println("Введите значения массива");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(reader.readLine());

                if (arr[i] < 1) {
                    System.out.println("Значения могут быть только натуральными числами");
                    return;
                }
            }
            System.out.println("Введите число К");
            int K = Integer.parseInt(reader.readLine());

            // Суммируем значения массива, которые кратны данному К
            int sum = 0;
            for (int j : arr) {
                if ((j % K) == 0) {
                    sum += j;
                }
            }
            System.out.println(sum);
        }
    }
}

