package programming_with_classes.simple_classes_and_objects.task10;

import java.util.Arrays;

public class AirlineArray {

    private Airline[] airlines;

    public AirlineArray(Airline[] airlines) {
        this.airlines = airlines;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public Airline[] getAirlinesByDestination(String destination) {
        return Arrays.stream(airlines)
                .filter(airline -> airline.getDestination().equalsIgnoreCase(destination))
                .toArray(Airline[]::new);
    }

    public Airline[] getAirlinesByDayOfWeek(DayOfWeek day) {
        return Arrays.stream(airlines)
                .filter(airline -> airline.getDay().equals(day))
                .toArray(Airline[]::new);
    }

    public Airline[] getAirlinesByDayOfWeek(DayOfWeek day, String time) {
        return Arrays.stream(airlines)
                .filter(airline -> airline.getDay().equals(day)
                        && airline.getDepartureTime().compareTo(time) > 0)
                .toArray(Airline[]::new);
    }
}