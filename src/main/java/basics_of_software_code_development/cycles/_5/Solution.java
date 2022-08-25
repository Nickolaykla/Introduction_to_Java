package basics_of_software_code_development.cycles._5;

/* Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых
больше или равен заданному е. Общий член ряда имеет вид: An = 1 / 2^n + 1 / 3^n
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double e = Double.parseDouble(reader.readLine());

            System.out.println(sum(e));
        }
    }

    public static double sum(double e) {
       int n = 0;
       double sum = 0;

       while (true) {
           double func = 1.0 / Math.pow(2, n) + 1.0 / Math.pow(3, n);
           sum += func;
           n++;
           if (func < e) break;
       }
       return sum;
    }
}
