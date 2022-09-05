package programming_with_classes.simple_classes_and_objects.task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Customer customer0 = new Customer(0, "Васильков", "Дмитрий", "Васильевич", "Петровская 11, 2", "115200", "512000");
        Customer customer1 = new Customer(1, "Петров", "Алексей", "Сергеевич", "Ангарская 12, 4", "110450", "600111");
        Customer customer2 = new Customer(2, "Иванова", "Наталья", "Павловна", "Железнодорожная 152, 11", "985100", "421113");
        Customer customer3 = new Customer(3, "Соколова", "Светлана", "Сергеевна", "Брестская 131, 68", "132111", "543678");
        Customer customer4 = new Customer(4, "Меньшиков", "Олег", "Евгеньевич", "Советская 12, 11", "911121", "513113");
        Customer customer5 = new Customer(5, "Сидоров", "Сергей", "Игоревич", "Интернациональная 150, 99", "832122", "123456");
        Customer customer6 = new Customer(6, "Камышов", "Илья", "Леонидович", "Пинская 18, 1", "999911", "754321");

        Collections.addAll(customers, customer0, customer1, customer2, customer3, customer4, customer5, customer6);

        CustomerList customer = new CustomerList(customers);

        // выводим список всех покупателей
        customer.getAllCustomers();

        //выводим список покупателей отсортированных по фамилии
        customer.getCustomersInNaturalOrder();

        // изменяем данные покупателя с id=5
        customer.updateCustomer(customer5, 5, "Степанов", "Сергей", "Игоревич",
                "Интернациональная 150, 99", "832122", "123456");
        System.out.println();

        System.out.println("Ищем измененного покупателя:");
        System.out.println(customer.findById(5) + "\n");

        customer.getAllCustomers();
        System.out.println();

        // удаляем покупателя
        customer.deleteCustomer(6);
        customer.getAllCustomers();
        System.out.println();

        System.out.println("Получаем список покупателей с номером кредитной карточки в заданном диапазоне:");
        customer.getCustomersByCreditCardNumber(800_000, 900_000);

    }
}
