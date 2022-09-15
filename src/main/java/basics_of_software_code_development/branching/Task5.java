package basics_of_software_code_development.branching;

// Вычислить значение функции

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите значение:");
            double i = Double.parseDouble(reader.readLine());

            System.out.println(function(i));
        }
    }

    public static double function(double i) {
        return i <= 3 ? (i * i - 3 * i + 9) : 1 / (Math.pow(i, 3) + 6);
    }
}