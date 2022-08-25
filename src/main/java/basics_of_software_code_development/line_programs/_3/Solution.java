package basics_of_software_code_development.line_programs._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вычислить значение выражения по формуле
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double x = Double.parseDouble(reader.readLine());
            double y = Double.parseDouble(reader.readLine());

            double result = function(x, y);
            System.out.printf("%.2f", result);
        }
    }
    public static double function(double x, double y) {
        return (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
    }
}
