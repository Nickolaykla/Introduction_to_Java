package algorithmization.decomposition;

import java.util.Scanner;

/*
Вычислить площадь правильного шестиугольника со стороной а, используя метод
вычисления площади треугольника.
* */
public class Task3 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите длину стороны шестиугольника: ");
            double a = in.nextDouble();

            System.out.print("Площадь правильного шестиугольника со стороной " + a + " = ");
            System.out.printf("%.3f", getHexagonSquare(a));
        }
    }

    public static double getTriangleSquare(double a) {
        if (a < 0) return -1;
        return a * a * Math.sqrt(3) / 4;
    }

    public static double getHexagonSquare(double a) {
        if (a < 0) return -1;
        return 6 * getTriangleSquare(a);
    }
}
