package basics_of_oop.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Payment.Product> products = new ArrayList<>();
        Payment payment = new Payment(products);

        Payment.Product product1 = payment.new Product("Телевизор", 250);
        Payment.Product product2 = payment.new Product("Шторы", 50);
        Payment.Product product3 = payment.new Product("Перфоратор", 290);
        Payment.Product product4 = payment.new Product("Наушники", 20);
        Payment.Product product5 = payment.new Product("Смартфон", 150);

        Collections.addAll(products, product1, product2, product3, product4, product5);

        payment.getProducts().forEach(System.out::println);
        System.out.println("Выберите товары для покупки(введите id товара), для выхода введите '0'");
        List<Payment.Product> orderList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = -1;
            while (i != 0) {
                i = Integer.parseInt(reader.readLine());
                Optional<Payment.Product> order = payment.makeOrder(i);
                order.ifPresent(orderList::add);
            }
            System.out.println("Список заказанных товаров:");
            orderList.forEach(System.out::println);

            double sum = payment.sumOfOrder(orderList);
            System.out.println("Сумма к оплате " + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}