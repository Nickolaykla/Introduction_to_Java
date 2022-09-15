package basics_of_software_code_development.cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Вычислить значения функции на отрезке [a,b] с шагом h
*/

public class Task2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите начало отрезка:");
            double a = Double.parseDouble(reader.readLine());

            System.out.println("Введите конец отрезка:");
            double b = Double.parseDouble(reader.readLine());

            System.out.println("Введите шаг:");
            double h = Double.parseDouble(reader.readLine());

            function(a, b, h);
        }
    }

    public static void function(double a, double b, double h) {
        if (a >= b) {
            throw new IllegalArgumentException("Неверно заданы значения отрезка");
        }
        double x = a;
        double y;

        while (x <= b) {
            if (x <= 2) {
                y = -x;

            } else {
                y = x;
            }
            System.out.println("x = " + x + "\t" + " y = " + y);
            x += h;
        }
    }
}
