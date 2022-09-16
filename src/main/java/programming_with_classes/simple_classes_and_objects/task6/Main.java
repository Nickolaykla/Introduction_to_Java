package programming_with_classes.simple_classes_and_objects.task6;

public class Main {
    public static void main(String[] args) {
        Time time = new Time(10, 50, 40);
        System.out.println("Изначальное время:");
        System.out.println(time + "\n");

        time.changeSeconds(time, 4000);
        System.out.println("Время после изменения на заданное количество секунд:");
        System.out.println(time + "\n");

        time.changeMinutes(time, 200);
        System.out.println("Время после изменения на заданное количество минут:");
        System.out.println(time + "\n");

        time.changeHours(time, 30);
        System.out.println("Время после изменения на заданное количество часов:");
        System.out.println(time);
    }
}