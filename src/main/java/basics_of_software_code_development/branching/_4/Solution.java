package basics_of_software_code_development.branching._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Заданы размеры А, В прямоугольного отверстия и размеры x, y, z кирпича. Определить,
пройдет ли кирпич через отверстие
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double A = Double.parseDouble(reader.readLine()); // высота отверстия
            double B = Double.parseDouble(reader.readLine()); // ширина отверстия
            double x = Double.parseDouble(reader.readLine()); // высота кирпича
            double y = Double.parseDouble(reader.readLine()); // ширина кирпича
            double z = Double.parseDouble(reader.readLine()); // длина кирпича

            System.out.println(willPass(A, B, x, y, z));
        }
    }

    public static boolean willPass(double A, double B, double x, double y, double z) {
        return  (x <= A && y <= B) || (x <= B && y <= A) ||
                (x <= A && z <= B) || (y <= B && z <= A) ||
                (x <= B && z <= A) || (y <= A && z <= B);
    }
}
