package basics_of_oop.task3;

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
        for (Holiday hol : holidays) {
            if(hol.equals(holiday)){
                System.out.println("Такой праздник уже есть в календаре.");
                return;
            }
        }
        holidays.add(holiday);
    }

    public void deleteHoliday(int id) {
        holidays.remove(id);
    }

    class Holiday {

        private String name;
        private String date;
        private int id;

        public Holiday(String name, String date) {
            if (name != null && date != null) {
                this.id = holidayID++;
                this.name = name;
                this.date = date;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name != null) {
                this.name = name;
            }
        }
        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            if (date != null) {
                this.date = date;
            }
        }

        @Override
        public String toString() {
            return "Holiday{" +
                    "name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    ", id=" + id +
                    '}';
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + date.hashCode();
            return  result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Holiday holiday = (Holiday) obj;

            return name.equals(holiday.name) && date.equals(holiday.date);
        }
    }
}