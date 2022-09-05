package programming_with_classes.simple_classes_and_objects.task10;

import java.util.Arrays;

public class AirlineArray {

    private Airline[] airlines;

    public AirlineArray(Airline[] airlines) {
        this.airlines = airlines;
    }

    public void getAllAirlines() {
        for (Airline line : airlines) {
            System.out.println(line);
        }
    }

    public void getAirlinesByDestination(String destination) {
        if (destination != null) {
            for (Airline line : airlines) {
                if (line.getDestination().equalsIgnoreCase(destination))
                    System.out.println(line);
            }
        } else {
            System.out.println("Неверно задан пункт назначения");
            throw new IllegalArgumentException();
        }
    }

    public void getAirlinesByDayOfWeek(DayOfWeek day) {
        if (day != null) {
            for (Airline line : airlines) {
                if (line.getDay().equals(day)) {
                    System.out.println(line);
                }
            }
        } else {
            System.out.println("Неверно задан день недели");
            throw new IllegalArgumentException();
        }
    }

    public void getAirlinesByDayOfWeek(DayOfWeek day, String time) {
        if (day != null && time != null) {
            Arrays.stream(airlines)
                    .filter(airline -> airline.getDay().equals(day)
                            && airline.getDepartureTime().compareTo(time) > 0)
                    .forEach(System.out::println);

        } else {
            System.out.println("Некорректные данные");
            throw new IllegalArgumentException();
        }
    }
}
