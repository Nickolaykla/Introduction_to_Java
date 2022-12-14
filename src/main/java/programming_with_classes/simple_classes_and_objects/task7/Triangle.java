package programming_with_classes.simple_classes_and_objects.task7;

/*
Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
площади, периметра и точки пересечения медиан.
*/
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