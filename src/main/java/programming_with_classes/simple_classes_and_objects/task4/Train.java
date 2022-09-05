package programming_with_classes.simple_classes_and_objects.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
массива по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен
пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
* */
public class Train {
    private String destinationName;
    private int numOfTrain;
    private String departureTime;

    public Train(String destinationName, int numOfTrain, String departureTime) {
        if (destinationName != null && numOfTrain > 0 && departureTime != null) {
            this.destinationName = destinationName;
            this.numOfTrain = numOfTrain;
            this.departureTime = departureTime;
        } else throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        Train train1 = new Train("Минск", 567, "12:00");
        Train train2 = new Train("Брест", 243, "08:15");
        Train train3 = new Train("Гомель", 128, "06:00");
        Train train4 = new Train("Витебск", 1197, "18:00");
        Train train5 = new Train("Минск", 767, "09:00");

        Train[] trains = {train1, train2, train3, train4, train5};

        // Сортируем и выводим поезда по номерам
        sortByNumber(trains);

        //Сортируем по названию пункта назначения, в случае совпадения - по времени отправления
        sortByDestination(trains);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите номер поезда для получения информации:");
            int number = Integer.parseInt(reader.readLine());

            // Получаем информацию о поезде по введенному номеру
            getInformationAboutTrain(trains, number);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // сортировка по номерам поездов
    public static void sortByNumber(Train[] trains) {
        System.out.println("Поезда, отсортированные по номерам: ");
        Arrays.stream(trains)
                .sorted(Comparator.comparingInt(Train::getNumOfTrain))
                .forEach(System.out::println);
    }

    // получение информации о поезде по введеному номеру
    public static void getInformationAboutTrain(Train[] trains, int number) {
        System.out.println("Информация о поезде:");
        if(Arrays.stream(trains).noneMatch(train -> train.getNumOfTrain() == number)) {
            System.out.println("Поезда с таким номером не существует");
            throw new IllegalArgumentException();
        }
        Arrays.stream(trains)
                .filter(train1 -> train1.getNumOfTrain() == number)
                .forEach(System.out::println);
    }

    // сортировка по названию пункта назначения
    public static void sortByDestination(Train[] trains) {
        System.out.println("Поезда, отсортированные по названию пункта назначения:");
        Arrays.stream(trains)
                .sorted(Comparator.comparing(Train::getDestinationName)
                .thenComparing(Train::getDepartureTime))
                .forEach(System.out::println);
    }

    public String getDestinationName() {
        return destinationName;
    }

    public int getNumOfTrain() {
        return numOfTrain;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destinationName='" + destinationName + '\'' +
                ", numOfTrain=" + numOfTrain +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
