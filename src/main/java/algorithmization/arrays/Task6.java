package algorithmization.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые
номера которых являются простыми числами
*/

public class Task6 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            if (n < 1) throw new IllegalArgumentException("Некорректная длина массива.");

            double[] arr = initArray(n);
            System.out.println("Исходный массив:");
            System.out.println(Arrays.toString(arr));

            System.out.println(sum(arr));
        }
    }
    public static double[] initArray(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 100 - 50;
        }
        return arr;
    }

    public static double sum(double[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(isPrime(i)) { // проверяем является ли индекс простым числом, если да, то суммируем элементы
                sum += arr[i];
            }
        }
        return sum;
    }
    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / i; i++) {
            if ((num % i) == 0) return false;
        }
        return true;
    }
}