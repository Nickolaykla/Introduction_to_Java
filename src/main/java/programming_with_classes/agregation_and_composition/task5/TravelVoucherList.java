package programming_with_classes.agregation_and_composition.task5;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelVoucherList {

    private List<TravelVoucher> vouchers;

    public TravelVoucherList(List<TravelVoucher> vouchers) {
        this.vouchers = vouchers;
    }

    public void getAllVouchers() {
        vouchers.forEach(System.out::println);
    }

    // Сортируем все путевки по цене
    public List<TravelVoucher> sortByPrice() {
        return vouchers.stream()
                .sorted(Comparator.comparingDouble(TravelVoucher::getPrice))
                .collect(Collectors.toList());
    }

    //Получаем все имеющиеся путевки по заданному цели путешествия
    public List<TravelVoucher> getAllVouchersByType(VoucherType type) {
        return vouchers.stream()
                .filter(travelVoucher -> travelVoucher.getVoucherType().equals(type))
                .collect(Collectors.toList());
    }

    // подбор путевок согласно заданным параметрам
    public List<TravelVoucher> searchVouchersForCustomer(TravelVoucher userInput) {
        return vouchers.stream()
                .filter(travelVoucher -> travelVoucher.getVoucherType().equals(userInput.getVoucherType()))
                .filter(travelVoucher -> travelVoucher.getPrice() <= userInput.getPrice())
                .filter(travelVoucher -> travelVoucher.getNumOfDays() <= userInput.getNumOfDays())
                .collect(Collectors.toList());
    }
}