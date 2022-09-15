package algorithmization.arrays;

/*
Дана последовательность действительных чисел а1, а2... а_n. Заменить все ее члены,
большие данного Z, этим числом. Подсчитать количество замен.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            if (n < 1) {
                throw new IllegalArgumentException("Введена некорректная длина массива");
            }

            System.out.println("Введите число Z: ");
            double Z = Double.parseDouble(reader.readLine());

            double[] arr = initArray(n);
            System.out.println("Исходный массив:");
            System.out.println(Arrays.toString(arr));

            changingElems(arr, Z);
        }
    }

    public static double[] initArray(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 50 - 25;
        }
        return arr;
    }

    public static void changingElems(double[] arr, double Z) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > Z) {
                arr[i] = Z;
                count++;
            }
        }
        System.out.println("Измененный массив: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Количество замен " + count);
    }
}