package basics_of_software_code_development.branching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Найти max{min(a,b),min(c,d)}

public class Task2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите значения a, b, c, d:");
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double c = Double.parseDouble(reader.readLine());
            double d = Double.parseDouble(reader.readLine());

            double result = findMax(a, b, c, d);
            System.out.println("Результат = " + result);
        }
    }

    public static double findMax(double a, double b, double c, double d) {
        return Math.max(Math.min(a, b), Math.min(c, d));
    }
}
