package algorithmization.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Даны действительные числа а1, а2...а_n. Поменять местами наибольший и наименьший элементы.
*/

public class Task4 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            if (n < 1) return;
            double[] arr = new double[n];

            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Double.parseDouble(reader.readLine());
            }
            System.out.println("Изначальный массив: ");
            System.out.println(Arrays.toString(arr));

            System.out.println("Измененный массив: ");
            minMaxExchange(arr);
        }
    }
    public static void minMaxExchange(double[] arr) {
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        double temp = arr[maxIndex];
        arr[maxIndex] = arr[minIndex];
        arr[minIndex] = temp;

        System.out.println(Arrays.toString(arr));
    }
}