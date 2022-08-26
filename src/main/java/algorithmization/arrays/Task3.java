package algorithmization.arrays;

/* Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем
отрицательных, положительных и нулевых элементов.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите длину массива: ");
            int n = Integer.parseInt(reader.readLine());
            double[] arr = new double[n];

            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Double.parseDouble(reader.readLine());
            }
            countingElems(arr);
        }
    }
    public static void countingElems(double[] arr) {
        int countPositive = 0;
        int countNegative = 0;
        int countZero = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) countPositive++;
            if(arr[i] < 0) countNegative++;
            if(arr[i] == 0) countZero++;
        }
        System.out.println("Количество положительных чисел = " + countPositive);
        System.out.println("Количество отрицательных чисел = " + countNegative);
        System.out.println("Количество нулей = " + countZero);
    }
}
