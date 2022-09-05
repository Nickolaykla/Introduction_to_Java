package programming_with_classes.simple_classes_and_objects.task10;
/*
Создать класс Airline. Определить конструкторы, set, get методы, toString(). Создать 2 класс, агрегирующий
массив типа Airline, с подходящими конструкторами и методами. Задать критерии вывода данных и вывести эти
данные на консоль.
Airline: пункт назначения, номер рейса, тип самолёта, время вылета, дни недели.
Найти и вывести:
а)список рейсов для заданного пункта назначения;
б)список рейсов для заданного дня недели;
с)список рейсов для заданного дня недели, время вылета для которых больше заданного.
* */

public class Airline {
    private String destination;
    private int flightNumber;
    private String airplaneType;
    private String departureTime;
    private DayOfWeek day;

    public Airline(String destination, int flightNumber, String airplaneType, String departureTime, DayOfWeek day) {
        setDestination(destination);
        setFlightNumber(flightNumber);
        setAirplaneType(airplaneType);
        setDepartureTime(departureTime);
        setDay(day);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (!destination.isEmpty()) {
            this.destination = destination;
        }
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        if (flightNumber > 0) {
            this.flightNumber = flightNumber;
        }
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        if (!airplaneType.isEmpty()) {
            this.airplaneType = airplaneType;
        }
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        if (!departureTime.isEmpty()) {
            this.departureTime = departureTime;
        }
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        if (day != null) {
            this.day = day;
        }
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", airplaneType='" + airplaneType + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", day=" + day +
                '}';
    }
}
