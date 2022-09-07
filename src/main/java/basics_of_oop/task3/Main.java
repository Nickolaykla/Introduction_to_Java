package basics_of_oop.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Calendar.Holiday> holidays = new ArrayList<>();
        Calendar calendar = new Calendar(holidays);
        Calendar.Holiday holiday1 = calendar.new Holiday("Международный женский день", "8 марта");
        Calendar.Holiday holiday2 = calendar.new Holiday("День защитника отечества", "23 февраля");
        Calendar.Holiday holiday3 = calendar.new Holiday("Новый год", "1 января");
        Calendar.Holiday holiday4 = calendar.new Holiday("Рождество", "7 января");
        Calendar.Holiday holiday5 = calendar.new Holiday("День космонавтики", "12 апреля");

        Collections.addAll(holidays, holiday1, holiday2, holiday3, holiday4, holiday5);

        System.out.println("Все праздники в календаре:");
        calendar.getAllHolidays().forEach(System.out::println);

        System.out.println("\n" + "Добавляем праздник в календарь");
        calendar.addHoliday(calendar.new Holiday("День научной фантастики", "2 января"));
        calendar.getAllHolidays().forEach(System.out::println);

        System.out.println("\n" + "Удаляем праздник из календаря");
        calendar.deleteHoliday(0);
        calendar.getAllHolidays().forEach(System.out::println);
    }
}
