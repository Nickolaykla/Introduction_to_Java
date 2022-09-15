package basics_of_software_code_development.branching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Даны два треугольника (в градусах). Определить, существует ли такой треугольник, и если да,
то будет ли он прямоугольным.
*/
public class Task1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите значения 2 углов треугольника:");
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());

            existingOfTriangle(a, b);
        }
    }

    public static void existingOfTriangle(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Заданы некорректные значения.");
        }

        if ((a + b) < 180) {
            System.out.println("Треугольник существует");
            if ((a + b) == 90 || a == 90 || b == 90) {
                System.out.println("Треугольник прямоугольный");
            }
        } else System.out.println("Треугольник не существует");
    }
}
