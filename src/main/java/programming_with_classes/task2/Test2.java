package programming_with_classes.task2;
/*
Создайте класс Test2 с двумя переменными. Добавьте конструктор с входными параметрами.
Добавьте конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get-
методы для полей экземпляра класса.
* */
public class Test2 {
    private double x;
    private double y;

    public static void main(String[] args) {
        Test2 testDefault = new Test2();
        System.out.println(testDefault);

        Test2 testParams = new Test2(10, 12);
        System.out.println(testParams);

        testDefault.setX(5);
        testDefault.setY(3.4);
        System.out.println(testDefault);

        System.out.println(testParams.getX());
        System.out.println(testParams.getY());
    }

    public Test2() {
        this.x = -1;
        this.y = -1;
    }

    public Test2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
