package algorithmization.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Даны целые числа а1, а2... а_n. Вывести на печать только те числа, для которых a_i > i.

public class Task5 {
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

            System.out.println("Введите число-ключ: ");
            int i = Integer.parseInt(reader.readLine());

            function(arr, i);
        }
    }

    public static void function(int[] arr, int i) {
        System.out.println("Числа, которые больше " + i + ":");
        for (int num : arr) {
            if (num > i) System.out.print(num + " ");
        }
    }
}
