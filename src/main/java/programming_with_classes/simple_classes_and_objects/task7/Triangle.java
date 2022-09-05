package programming_with_classes.simple_classes_and_objects.task7;

/*
Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
площади, периметра и точки пересечения медиан.
* */
public class Triangle {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public Triangle() {
    }

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

    public double getSquare(Triangle triangle) {
        return Math.abs(((triangle.x1 - triangle.x3) * (triangle.y2 - triangle.y3) -
                (triangle.x2 - triangle.x3) * (triangle.y1 - triangle.y3)) / 2);
    }

    public double getPerimeter(Triangle triangle) {
        double side1 = Math.sqrt(Math.pow(triangle.x1 - triangle.x2, 2) + Math.pow(triangle.x1 - triangle.y2, 2));
        double side2 = Math.sqrt(Math.pow(triangle.x2 - triangle.x3, 2) + Math.pow(triangle.y2 - triangle.y3, 2));
        double side3 = Math.sqrt(Math.pow(triangle.x3 - triangle.x1, 2) + Math.pow(triangle.y3 - triangle.y1, 2));
        return side1 + side2 + side3;
    }

    public void getMedianPoint(Triangle triangle) {
        double x = (triangle.x1 + triangle.x2 + triangle.x3) / 3;
        double y = (triangle.y1 + triangle.y2 + triangle.y3) / 3;
        System.out.printf("Точка пересечения медиан = {%.2f, %.2f} \n", x, y);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                '}';
    }
}
