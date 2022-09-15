package basics_of_software_code_development.line_programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вычислить значение выражения по формуле (sinx + cosy) / (cosx - siny) * tgxy
public class Task3 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите значения х и у:");
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
