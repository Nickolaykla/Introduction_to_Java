package basics_of_software_code_development.cycles;

/* Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых
больше или равен заданному е. Общий член ряда имеет вид: An = 1 / 2^n + 1 / 3^n
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите е:");
            double e = Double.parseDouble(reader.readLine());

            System.out.println(sum(e));
        }
    }

    public static double sum(double e) {
       int n = 20;
       double sum = 0;
       double An = 0;

        for (int i = 2; i <= n; i++) {
            An = 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
            if(Math.abs(An) >= e) {
                sum += An;
            }
        }

       return sum;
    }
}
