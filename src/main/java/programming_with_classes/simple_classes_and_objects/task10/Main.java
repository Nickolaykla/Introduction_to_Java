package programming_with_classes.simple_classes_and_objects.task10;

import java.util.Arrays;

import static programming_with_classes.simple_classes_and_objects.task10.AirplaneType.*;
import static programming_with_classes.simple_classes_and_objects.task10.DayOfWeek.*;

public class Main {
    public static void main(String[] args) {
        Airline airline1 = new Airline("Минск", 111, BOEING, "12:20", TUESDAY);
        Airline airline2 = new Airline("Москва", 80, AIRBUS, "8:00", MONDAY);
        Airline airline3 = new Airline("Варшава", 243, BOEING, "19:45", SUNDAY);
        Airline airline4 = new Airline("Рига", 54, BOEING, "21:38", SUNDAY);
        Airline airline5 = new Airline("Минск", 13, BOEING, "23:55", TUESDAY);

        Airline[] airlines = new Airline[]{airline1, airline2, airline3, airline4, airline5};
        AirlineArray airlineArray = new AirlineArray(airlines);

        System.out.println("Список всех линий:");
        Arrays.stream(airlineArray.getAirlines()).forEach(System.out::println);

        System.out.println("\n" + "Список рейсов для заданного пункта назначения:");
        Arrays.stream(airlineArray.getAirlinesByDestination("Минск")).forEach(System.out::println);

        System.out.println("\n" + "Список рейсов для заданного дня недели:");
        Arrays.stream(airlineArray.getAirlinesByDayOfWeek(SUNDAY)).forEach(System.out::println);

        System.out.println("\n" + "Рейсы во вторник после 14-00:");
       Arrays.stream(airlineArray.getAirlinesByDayOfWeek(TUESDAY, "14:00")).forEach(System.out::println);
    }
}