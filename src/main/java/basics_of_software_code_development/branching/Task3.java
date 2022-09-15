package basics_of_software_code_development.branching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Даны три точки А(х1, у1), B(x2, y2), C(x3, y3). Определить, будут ли они расположены на одной
прямой.
*/

public class Task3 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите координаты 1 точки:");
            double x1 = Double.parseDouble(reader.readLine());
            double y1 = Double.parseDouble(reader.readLine());

            System.out.println("Введите координаты 2 точки:");
            double x2 = Double.parseDouble(reader.readLine());
            double y2 = Double.parseDouble(reader.readLine());

            System.out.println("Введите координаты 3 точки:");
            double x3 = Double.parseDouble(reader.readLine());
            double y3 = Double.parseDouble(reader.readLine());

            System.out.println(isOnLine(x1, y1, x2, y2, x3, y3));
        }
    }

    public static boolean isOnLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return ((x3 - x1) / (x2 - x1)) == ((y3 - y1) / (y2 - y1));
    }
}
