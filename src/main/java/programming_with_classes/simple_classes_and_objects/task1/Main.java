package programming_with_classes.simple_classes_and_objects.task1;

public class Main {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println("Значения a и b:");
        System.out.println(test1.getA() + " " + test1.getB());

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
}
