package programming_with_classes.simple_classes_and_objects.task2;

public class Main {
    public static void main(String[] args) {
        Test2 testDefault = new Test2();
        System.out.println("Значения по умолчанию:");
        System.out.println(testDefault);

        System.out.println("С заданными параметрами");
        Test2 testParams = new Test2(10, 12);
        System.out.println(testParams);

        System.out.println("Изменение значений по умолчанию:");
        testDefault.setX(5);
        testDefault.setY(3.4);
        System.out.println(testDefault);
    }
}