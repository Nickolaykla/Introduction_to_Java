package programming_with_classes.simple_classes_and_objects.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Train train1 = new Train("Минск", 567, "12:00");
        Train train2 = new Train("Брест", 243, "08:15");
        Train train3 = new Train("Гомель", 128, "06:00");
        Train train4 = new Train("Витебск", 1197, "18:00");
        Train train5 = new Train("Минск", 767, "09:00");

        Train[] trains = {train1, train2, train3, train4, train5};

        Train train = new Train();

        System.out.println("Сортировка поездов по номерам:");
        Train[] trainsByNums = train.sortByNumber(trains);
        Arrays.stream(trainsByNums).forEach(System.out::println);
        System.out.println();

        System.out.println("Сортировка по названию пункта назначения, в случае совпадения - по времени отправления:");
        Train[] trainsByDestin = train.sortByDestination(trains);
        Arrays.stream(trainsByDestin).forEach(System.out::println);
        System.out.println();

        // Получаем информацию о поезде по введенному номеру
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите номер поезда для получения информации:");
            int number = Integer.parseInt(reader.readLine());
            Optional<Train> infoTrain = train.getInformationAboutTrain(trains, number);
            if(infoTrain.isPresent()) {
                System.out.println(infoTrain.get());
            } else System.out.println("Поезда с таким номером нет.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}