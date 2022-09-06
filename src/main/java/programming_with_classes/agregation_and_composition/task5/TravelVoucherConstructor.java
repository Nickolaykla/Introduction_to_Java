package programming_with_classes.agregation_and_composition.task5;

// Класс предназначен для создания пользователем путёвки и получения предложения по заданной путёвке.
public class TravelVoucherConstructor {

    public VoucherType chooseVoucherType(String type) {
        switch (type) {
            case "REST":
                return VoucherType.REST;
            case "EXCURSION":
                return VoucherType.EXCURSION;
            case "TREATMENT":
                return VoucherType.TREATMENT;
            case "SHOPPING":
                return VoucherType.SHOPPING;
            case "CRUISE":
                return VoucherType.CRUISE;
            default:
                throw new IllegalArgumentException();
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
