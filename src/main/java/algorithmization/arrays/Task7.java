package algorithmization.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Даны действительные числа а1, а2 ... а_n. Найти max(d1+a_2n, a_2 + a_2n-1..., a_n + a_n+1)

public class Task7 {
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
            System.out.println(maxValue(arr));
        }
    }

    public static double maxValue(double[] arr) {
        double maxVal = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            double testVal = arr[i] + arr[arr.length - 1 - i];
            if (testVal > maxVal) {
                maxVal = testVal;
            }
        }
        return maxVal;
    }
}
