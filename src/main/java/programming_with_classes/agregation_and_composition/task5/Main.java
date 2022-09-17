package programming_with_classes.agregation_and_composition.task5;

import programming_with_classes.agregation_and_composition.task5.enums.FoodType;
import programming_with_classes.agregation_and_composition.task5.enums.Transport;
import programming_with_classes.agregation_and_composition.task5.enums.VoucherType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static programming_with_classes.agregation_and_composition.task5.enums.FoodType.*;
import static programming_with_classes.agregation_and_composition.task5.enums.Transport.*;
import static programming_with_classes.agregation_and_composition.task5.enums.VoucherType.*;

public class Main {
    public static void main(String[] args) {
        TravelVoucher voucher1 = new TravelVoucher(REST, HALF_BOARD, 800, 7, AIRPLANE);
        TravelVoucher voucher2 = new TravelVoucher(EXCURSION, BED_N_BREAKFAST, 200, 2, BUS);
        TravelVoucher voucher3 = new TravelVoucher(TREATMENT, FULL_BOARD, 1000, 10, TRAIN);
        TravelVoucher voucher4 = new TravelVoucher(SHOPPING, ROOM_ONLY, 300, 3, CAR);
        TravelVoucher voucher5 = new TravelVoucher(CRUISE, ALL_INCLUSIVE, 2700, 14, SHIP);
        TravelVoucher voucher6 = new TravelVoucher(REST, FULL_BOARD, 900, 8, BUS);
        List<TravelVoucher> vouchers = new ArrayList<>();
        Collections.addAll(vouchers, voucher1, voucher2, voucher3, voucher4, voucher5, voucher6);

        TravelVoucherList travelVoucherList = new TravelVoucherList(vouchers);
        System.out.println("Список всех путёвок:");
        travelVoucherList.getAllVouchers();

        System.out.println("\n" + "Список всех имеющихся путёвок, отсортированных по ценам:");
        travelVoucherList.sortByPrice().forEach(System.out::println);

        System.out.println("\n" + "Список имеющихся путёвок по заданной цели путешествия:");
        travelVoucherList.getAllVouchersByType(REST).forEach(System.out::println);

        System.out.println("\n" + "Путёвки по заданному количеству дней и предложение путёвок с большим количеством дней:");
        travelVoucherList.getAllVouchersByDays(10).forEach(System.out::println);

        //конструирование и последующий поиск путёвки по заданным параметрам
        TravelVoucherConstructor constructor = new TravelVoucherConstructor();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("\n" + "Введите тип путешествия(rest, excursion, treatment, shopping, cruise):");
            VoucherType voucherType = constructor.chooseVoucherType(reader.readLine());

            System.out.println("Введите тип питания (Без питания = ro, только завтрак = bnb, Завтрак и ужин = hb," +
                    "Завтрак, обед, ужин = fb, Всё включено = ai:");
            FoodType foodType = constructor.chooseFoodType(reader.readLine());

            System.out.println("Введите ориентировочную цену:");
            double cost = Double.parseDouble(reader.readLine());

            System.out.println("Введите количество дней:");
            int dayNum = Integer.parseInt(reader.readLine());

            System.out.println("Введите тип транспорта(car, bus, airplane, train, ship):");
            Transport transport = constructor.chooseTransport(reader.readLine());

            //Создаём путевку по введенным данным и пробуем подобрать из имеющихся путёвок
            TravelVoucher travelVoucher = new TravelVoucher(voucherType, foodType, cost, dayNum, transport);

            System.out.println("Предложения по введенным данным:");
            travelVoucherList.searchVouchersForCustomer(travelVoucher).forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}