package basics_of_software_code_development.branching._5;

// Вычислить значение функции

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = Integer.parseInt(reader.readLine());

            System.out.println(function(i));
        }
    }
    public static double function(int i) {
        if (i <= 3) {
            return i * i - 3 * i + 9;
        } else return 1 / (Math.pow(i, 3) + 6);
    }
}

