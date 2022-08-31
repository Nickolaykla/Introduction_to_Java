package algorithmization.decomposition;

import java.util.Scanner;

/*
Даны числа X, Y, Z, T - длины сторон четырехугольника. Написать метод(методы) вычисления
его площади, если угол между сторонами длиной Х и У - прямой.
* */
public class Task9 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите стороны четырехугольника: ");
            double x = in.nextDouble();
            double y = in.nextDouble();
            double z = in.nextDouble();
            double t = in.nextDouble();

            if (x <= 0 || y <= 0 || z <= 0 || t <= 0) {
                System.out.println("Введены некорректные данные");
                throw new IllegalArgumentException();
            }
            // Вычислим гипотенузу прямоугольного треугольника / сторону 2 треугольника
            double hypot = Math.sqrt(x * x + y * y);
            if (triangleCheck(hypot, x, y) && triangleCheck(hypot, z, t)) {
                double firstTriangleSq = getFirstTriangleSquare(x, y); // площадь 1 треугольника
                double secondTriangleSq = getSecondTriangleSquare(hypot, z, t); // площадь 2 треугольника
                double getQuadSq = getQuadrilateralSquare(firstTriangleSq, secondTriangleSq); // площадь четырехугольн.
                System.out.printf("%.2f", getQuadSq);
            } else {
                System.out.println("Введены неверные данные");
                throw new IllegalArgumentException();
            }
        }
    }

    // проверка на существование треугольника(сумма 2 сторон должна быть больше 3 стороны)
    public static boolean triangleCheck(double a, double b, double c) {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    // Находим площадь прямоугольного треугольника
    public static double getFirstTriangleSquare(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException();
        }
        return a * b / 2;
    }

    // Находим площадь произвольного треугольника
    public static double getSecondTriangleSquare(double a, double b, double c) {
        // Находим полупериметр
        if (triangleCheck(a, b, c)) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else System.out.println("Заданы некорректные данные");
        return -1;
    }

    // Находим площадь четырехугольника, складывая площади 2 треугольников
    public static double getQuadrilateralSquare(double a, double b) {
        return a + b;
    }
}
