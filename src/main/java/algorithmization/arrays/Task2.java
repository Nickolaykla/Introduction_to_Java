package algorithmization.arrays;

/*
Дана последовательность действительных чисел а1, а2... а_n. Заменить все ее члены,
большие данного Z, этим числом. Подсчитать количество замен.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            double[] arr = new double[n];

            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Double.parseDouble(reader.readLine());
            }

            System.out.println("Введите число Z: ");
            double Z = Double.parseDouble(reader.readLine());

            changingElems(arr, Z);
        }
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
