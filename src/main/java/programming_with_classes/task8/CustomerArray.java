package programming_with_classes.task8;

import java.util.*;

public class CustomerArray {

    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Customer customer0 = new Customer(0, "Васильков", "Дмитрий", "Васильевич", "Петровская 11, 2", "115200", "512000");
        Customer customer1 = new Customer(1, "Петров", "Алексей", "Сергеевич", "Ангарская 12, 4", "110450", "600111");
        Customer customer2 = new Customer(2, "Иванова", "Наталья", "Павловна", "Железнодорожная 152, 11", "985100", "421113");
        Customer customer3 = new Customer(3, "Соколова", "Светлана", "Сергеевна", "Брестская 131, 68", "132111", "543678");
        Customer customer4 = new Customer(4, "Меньшиков", "Олег", "Евгеньевич", "Советская 12, 11", "911121", "513113");
        Customer customer5 = new Customer(5, "Сидоров", "Сергей", "Игоревич", "Интернациональная 150, 99", "832122", "123456");
        Customer customer6 = new Customer(6, "Камышов", "Илья", "Леонидович", "Пинская 18, 1", "999911", "754321");

        Collections.addAll(customers, customer0, customer1, customer2, customer3, customer4, customer5, customer6);

        // выводим список всех покупателей
        getAllCustomers(customers);

        //выводим список покупателей отсортированных по фамилии
        getCustomersInNaturalOrder(customers);

        // изменяем данные покупателя с id=5
        updateCustomer(customer5, 5, "Степанов", "Сергей", "Игоревич",
                "Интернациональная 150, 99", "832122", "123456");
        System.out.println();

        System.out.println("Ищем измененного покупателя:");
        System.out.println(findById(customers, 5) + "\n");

        getAllCustomers(customers);
        System.out.println();

        // удаляем покупателя
        deleteCustomer(6);
        getAllCustomers(customers);
        System.out.println();

        System.out.println("Получаем список покупателей с номером кредитной карточки в заданном диапазоне:");
        getCustomersByCreditCardNumber(customers,800_000, 900_000);

    }

    // Список всех покупателей
    public static void getAllCustomers(List<Customer> list) {
        System.out.println("Список покупателей:");
        list.forEach(System.out::println);
    }

    // Сортировка по фамилии
    public static void getCustomersInNaturalOrder(List<Customer> list) {
        System.out.println("По фамилии:");
        list.stream()
                .sorted(Comparator.comparing(Customer::getSurName))
                .forEach(System.out::println);
    }

    // поиск покупателя по id
    public static Customer findById(List<Customer> list, int id) {
        return list.stream()
                .filter(customer1 -> customer1.getId() == id)
                .findAny()
                .orElse(null);
    }

    // удаление покупателя
    public static void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
    }

    // добавление покупателя
    public static void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        } else {
            System.out.println("Такой покупатель уже существует");
        }
    }

    // изменение данных покупателя
    public static void updateCustomer(
            Customer customer, int id, String surName, String firstName, String lastName,
            String address, String creditCardNumber, String bankAccountNumber) {

        if(customer.getId() != id) {
            System.out.println("Введен неверный id");
            return;
        }

        customer.setSurName(surName);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setCreditCardNumber(creditCardNumber);
        customer.setBankAccountNumber(bankAccountNumber);
        customers.set(id, customer);
    }

    // получаем список покупателей, у которых номер кредитной карточки находится в заданном диапазоне
    public static void getCustomersByCreditCardNumber(List<Customer> list, int start, int end) {
        list.stream()
                .filter(customer -> Integer.parseInt(customer.getCreditCardNumber()) >= start
                        && Integer.parseInt(customer.getCreditCardNumber()) <= end)
                .forEach(System.out::println);
    }
}
