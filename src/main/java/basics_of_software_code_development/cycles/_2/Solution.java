package basics_of_software_code_development.cycles._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Вычислить значения функции на отрезке [a,b] с шагом h
 * */

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double h = Double.parseDouble(reader.readLine());

            function(a, b, h);
        }
    }

    public static void function(double a, double b, double h) {
        double x = a;
        double y;

        while (x <= b) {
            if (x <= 2) {
                y = -x;

            } else {
                y = x;
            }
            System.out.println("x = " + x + "     y = " + y);

            x += h;
        }
    }
}
