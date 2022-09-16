package programming_with_classes.simple_classes_and_objects.task1;

/*
Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и методы изменения этих
переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который
находит наибольшее значение из этих двух переменных.
*/

public class Test1 {
    private int a = 10;
    private int b = 20;

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