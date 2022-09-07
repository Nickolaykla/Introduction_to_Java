package basics_of_oop.task3;

import java.util.ArrayList;
import java.util.List;

/*
Создать класс Календарь с внутренним классом, с помощью объектов которого можно
хранить информацию о выходных и праздничных днях.
*/
public class Calendar {

    private List<Holiday> holidays;
    private static int holidayID;

    public Calendar(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public List<Holiday> getAllHolidays() {
        return holidays;
    }

    public void addHoliday(Holiday holiday) {
        if (!holidays.contains(holiday)) {
            holidays.add(holiday);
        }
    }

    public void deleteHoliday(int id) {
        holidays.remove(id);
    }

    class Holiday {

        private String name;
        private String date;
        private int id;

        public Holiday(String name, String date) {
            this.id = holidayID++;
            this.name = name;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Holiday{" +
                    "name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
