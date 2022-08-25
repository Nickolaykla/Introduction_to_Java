package basics_of_software_code_development.line_programs._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вычислить значение выражения по заданной формуле.
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double c = Double.parseDouble(reader.readLine());

            double result = function(a, b, c);
            System.out.printf("%.2f", result);
        }
    }

    public static double function(double a, double b, double c) {
        return (b + Math.sqrt(b * b + 4.0 * a * c)) / 2 * a - (Math.pow(a, 3) * c) + Math.pow(b, -2);
    }
}
