package basics_of_software_code_development.branching._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Найти max{min(a,b),min(c,d)}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double c = Double.parseDouble(reader.readLine());
            double d = Double.parseDouble(reader.readLine());

            double result = findMax(a, b, c, d);
            System.out.println(result);
        }
    }

    public static double findMax(double a, double b, double c, double d) {
        return Math.max(Math.min(a, b), Math.min(c, d));
    }
}
