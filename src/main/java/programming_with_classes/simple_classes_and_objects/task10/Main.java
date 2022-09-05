package programming_with_classes.simple_classes_and_objects.task10;

public class Main {
    public static void main(String[] args) {
        Airline airline1 = new Airline("Минск", 111, "Boeing", "12:20", DayOfWeek.TUESDAY);
        Airline airline2 = new Airline("Москва", 80, "Airbus", "8:00", DayOfWeek.MONDAY);
        Airline airline3 = new Airline("Варшава", 243, "Boeing", "19:45", DayOfWeek.SUNDAY);
        Airline airline4 = new Airline("Рига", 54, "Boeing", "21:38", DayOfWeek.SUNDAY);
        Airline airline5 = new Airline("Минск", 13, "Airbus", "23:55", DayOfWeek.TUESDAY);

        Airline[] airlines = new Airline[]{airline1, airline2, airline3, airline4, airline5};
        AirlineArray airlineArray = new AirlineArray(airlines);

        System.out.println("Список всех линий:");
        airlineArray.getAllAirlines();
        System.out.println();

        airlineArray.getAirlinesByDestination("Москва");
        System.out.println();

        airlineArray.getAirlinesByDayOfWeek(DayOfWeek.TUESDAY);
        System.out.println();

        System.out.println("Рейсы во вторник после 14-00:");
        airlineArray.getAirlinesByDayOfWeek(DayOfWeek.TUESDAY, "12:00");
    }
}
