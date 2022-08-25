package basics_of_software_code_development.line_programs._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double c = Double.parseDouble(reader.readLine());

            double z = function(a, b, c);
            System.out.printf("%.2f", z);
        }
    }
    public static double function(double a, double b, double c) {
        return  ((a-3) * b / 2) + c;
    }
}
