package programming_with_classes.agregation_and_composition.task5;

import programming_with_classes.agregation_and_composition.task5.enums.FoodType;
import programming_with_classes.agregation_and_composition.task5.enums.Transport;
import programming_with_classes.agregation_and_composition.task5.enums.VoucherType;

// Класс предназначен для создания пользователем путёвки и получения предложения по заданной путёвке.
public class TravelVoucherConstructor {

    public VoucherType chooseVoucherType(String type) {
        switch (type) {
            case "rest":
                return VoucherType.REST;
            case "excursion":
                return VoucherType.EXCURSION;
            case "treatment":
                return VoucherType.TREATMENT;
            case "shopping":
                return VoucherType.SHOPPING;
            case "cruise":
                return VoucherType.CRUISE;
            default:
                throw new IllegalArgumentException("Некорректно введен тип путешествия");
        }
    }

    public FoodType chooseFoodType(String type) {
        switch (type) {
            case "ro":
                return FoodType.ROOM_ONLY;
            case "bnb":
                return FoodType.BED_N_BREAKFAST;
            case "hb":
                return FoodType.HALF_BOARD;
            case "fb":
                return FoodType.FULL_BOARD;
            case "ai":
                return FoodType.ALL_INCLUSIVE;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int chooseNumOfDays(int number) {
        if (number <= 0) {
            System.out.println("Неверно введено количество дней");
            throw new IllegalArgumentException();
        }
        return number;
    }

    public double setPrice(double a) {
        if (a <= 0) {
            System.out.println("Неверно задана цена");
            throw new IllegalArgumentException();
        }
        return a;
    }

    public Transport chooseTransport(String transport) {
        switch (transport) {
            case "car":
                return Transport.CAR;
            case "bus":
                return Transport.BUS;
            case "airplane":
                return Transport.AIRPLANE;
            case "train":
                return Transport.TRAIN;
            case "ship":
                return Transport.SHIP;
            default:
                throw new IllegalArgumentException();
        }
    }
}