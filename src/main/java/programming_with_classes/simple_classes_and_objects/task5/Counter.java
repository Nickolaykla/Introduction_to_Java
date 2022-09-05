package programming_with_classes.simple_classes_and_objects.task5;

/*
Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
позволяющий получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
* */
public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public Counter(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        // счётчик со стартовым значением по умолчанию
        Counter counter = new Counter();
        counter.increment();
        System.out.println("counter = " + counter.getCount());
        counter.decrementInRange(20);
        System.out.println("counter = " + counter.getCount());

        // счётчик с заданным стартовым значением
        Counter counter1 = new Counter(100);
        counter1.incrementInRange(500);
        System.out.println("counter1 = " + counter1.getCount());
        counter1.decrement();
        System.out.println("counter1 = " + counter1.getCount());
    }

    public void incrementInRange(int range) {
        while (range > 0) {
            increment();
            range--;
        }
    }

    public void decrementInRange(int range) {
        while (range > 0) {
            decrement();
            range--;
        }
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
