package basics_of_software_code_development.line_programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вычислить значение выражения по заданной формуле (b + Math.sqrt(b*b + 4ac)) / 2a - a^3c + b^-2
public class Task2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите значения a, b, c:");
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double c = Double.parseDouble(reader.readLine());

            double result = function(a, b, c);
            System.out.printf("%.2f", result);
        }
    }

    public static double function(double a, double b, double c) {
        double discrim = b * b + 4.0 * a * c;
        if (discrim >= 0 && a != 0 && b != 0)
         return  (b + Math.sqrt(discrim)) / 2 * a - Math.pow(a, 3) * c + Math.pow(b, -2);

        else {
            if(discrim < 0) {
                throw new ArithmeticException("Извлечение корня из отрицательного числа");
            } else if (a == 0) {
                throw new ArithmeticException("Деление на 0");
            } else {
                throw new ArithmeticException("Возведение 0 в степень");
            }
        }
    }
}