package basics_of_software_code_development.line_programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 Дано действительное число R вида nnn.ddd(три цифровых разряда в дробной и целой частях).
 Поменять местами дробную и целую части числа и вывести полученное значение числа.
*/
public class Task4 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите число формата nnn.ddd:");
            double a = Double.parseDouble(reader.readLine());

            double result = reverseFunction(a);
            System.out.printf("%.3f", result);
        }
    }
    public static double reverseFunction(double a) {
        double firstPart = (a * 1000) % 1000; // Дробную часть делаем целой.
        double secondPart = ((a * 1000) - firstPart) / 1_000_000; // Целую -  дробной.
        return firstPart + secondPart;
    }
}
