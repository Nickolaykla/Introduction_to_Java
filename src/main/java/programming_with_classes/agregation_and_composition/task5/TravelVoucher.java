package programming_with_classes.agregation_and_composition.task5;

import programming_with_classes.agregation_and_composition.task5.enums.FoodType;
import programming_with_classes.agregation_and_composition.task5.enums.Transport;
import programming_with_classes.agregation_and_composition.task5.enums.VoucherType;

/*
Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки различного типа
(отдых, экскурсии, лечение, шоппинг, круиз и т.д.) для оптимального выбора. Учитывать возможность выбора
транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
*/

public class TravelVoucher {
    private VoucherType voucherType;
    private FoodType foodType;
    private double price;
    private int numOfDays;
    private Transport transport;

    public TravelVoucher(VoucherType voucherType, FoodType foodType, double price, int numOfDays, Transport transport) {
        if (voucherType != null && foodType != null && price > 0 && numOfDays > 0 && transport != null) {
            this.voucherType = voucherType;
            this.foodType = foodType;
            this.price = price;
            this.numOfDays = numOfDays;
            this.transport = transport;
        }
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(VoucherType voucherType) {
        if (voucherType != null) {
            this.voucherType = voucherType;
        }
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        if (foodType != null) {
            this.foodType = foodType;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        if (numOfDays > 0) {
            this.numOfDays = numOfDays;
        }
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        if (transport != null) {
            this.transport = transport;
        }
    }

    @Override
    public String toString() {
        return "TravelVoucher{" +
                "voucherType=" + voucherType +
                ", foodType=" + foodType +
                ", price=" + price +
                ", numOfDays=" + numOfDays +
                ", transport='" + transport + '\'' +
                '}';
    }
}