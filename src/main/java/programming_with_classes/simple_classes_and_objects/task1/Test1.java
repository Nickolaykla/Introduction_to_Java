package programming_with_classes.simple_classes_and_objects.task1;

/*
Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и методы изменения этих
переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который
находит наибольшее значение из этих двух переменных.
* */
public class Test1 {
    private int a = 10;
    private int b = 20;

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println("Значения a и b:");
        System.out.println(test1);

        System.out.println("Изменение значений a и b:");
        test1.setA(20);
        test1.setB(30);
        System.out.println(test1);

        System.out.println("Сумма значений a и b:");
        int sum = test1.sum(test1.getA(), test1.getB());
        System.out.println(sum);

        System.out.println("Наибольшее значение:");
        int max = test1.max(test1.getA(), test1.getB());
        System.out.println(max);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    @Override
    public String toString() {
        return "Test1{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
