package programming_with_classes.simple_classes_and_objects.task7;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        Triangle triangle1 = new Triangle(3, 4, 5, 2, 5, 6);
        System.out.println("Координаты 1 треугольника:");
        System.out.println(triangle1);
        double sq = triangle.getSquare(triangle1);
        System.out.println("Площадь 1 треугольника равна = " + sq);
        double perim = triangle.getPerimeter(triangle1);
        System.out.printf("Периметр 1 треугольника равен = %.2f \n", perim);
        triangle.getMedianPoint(triangle1);

        System.out.println("=================================================================");

        Triangle triangle2 = new Triangle(20, 32, 15, 24, 18, 36);
        System.out.println("Координаты 2 треугольника:");
        System.out.println(triangle2);
        double sq2 = triangle.getSquare(triangle2);
        System.out.println("Площадь 2 треугольника равна = " + sq2);
        double perim2 = triangle.getPerimeter(triangle2);
        System.out.printf("Периметр 2 треугольника равен = %.2f \n", perim2);
        triangle.getMedianPoint(triangle2);
    }
}