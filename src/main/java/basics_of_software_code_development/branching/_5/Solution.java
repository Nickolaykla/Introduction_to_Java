package basics_of_software_code_development.branching._5;

// Вычислить значение функции

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double i = Double.parseDouble(reader.readLine());

            System.out.println(function(i));
        }
    }

    public static double function(double i) {
        return i <= 3 ? (i * i - 3 * i + 9) : 1 / (Math.pow(i, 3) + 6);
    }
}

