package programming_with_classes.simple_classes_and_objects.task5;

public class Main {
    public static void main(String[] args) {
        // счётчик со стартовым значением по умолчанию
        Counter counter = new Counter();
        System.out.println("Создаём счётчик со значением по умолчанию = " + counter.getCount());

        System.out.println("Увеличиваем значение на 1 ");
        counter.increment();
        System.out.println("counter = " + counter.getCount());

        System.out.println("Уменьшаем на 1 в заданном диапазоне:");
        counter.decrementInRange(20);
        System.out.println("counter = " + counter.getCount());

        // счётчик с заданным стартовым значением
        System.out.println("Создаём счётчик со стартовым значением и увеличиваем на 1 в заданном диапазоне:");
        Counter counter1 = new Counter(100);
        counter1.incrementInRange(500);
        System.out.println("counter1 = " + counter1.getCount());

        System.out.println("Уменьшаем на 1:");
        counter1.decrement();
        System.out.println("counter1 = " + counter1.getCount());
    }
}