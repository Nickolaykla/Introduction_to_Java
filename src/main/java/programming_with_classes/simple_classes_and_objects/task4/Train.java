package programming_with_classes.simple_classes_and_objects.task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/*
Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
массива по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен
пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
*/

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

    public Train() {
    }

    // сортировка по номерам поездов
    public Train[] sortByNumber(Train[] trains) {
        if (trains != null) {
            return Arrays.stream(trains)
                    .sorted(Comparator.comparingInt(Train::getNumOfTrain))
                    .toArray(Train[]::new);
        } else throw new IllegalArgumentException("Переданы некорректные данные.");
    }

    // получение информации о поезде по введенному номеру
    public Optional<Train> getInformationAboutTrain(Train[] trains, int number) {
        return Arrays.stream(trains)
                .filter(train1 -> train1.getNumOfTrain() == number)
                .findAny();
    }

    // сортировка по названию пункта назначения
    public Train[] sortByDestination(Train[] trains) {
        if (trains != null) {
            return Arrays.stream(trains)
                    .sorted(Comparator.comparing(Train::getDestinationName)
                            .thenComparing(Train::getDepartureTime))
                    .toArray(Train[]::new);
        } else throw new IllegalArgumentException("Переданы некорректные данные");
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

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public void setNumOfTrain(int numOfTrain) {
        this.numOfTrain = numOfTrain;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
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