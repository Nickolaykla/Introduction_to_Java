package programming_with_classes.simple_classes_and_objects.task8;

import java.util.*;

public class CustomerList {

    private List<Customer> customers;

    public CustomerList(List<Customer> customers) {
        this.customers = customers;
    }

    // Список всех покупателей
    public void getAllCustomers() {
        System.out.println("Список покупателей:");
        customers.forEach(System.out::println);
    }

    // Сортировка по фамилии
    public void getCustomersInNaturalOrder() {
        System.out.println("По фамилии:");
        customers.stream()
                .sorted(Comparator.comparing(Customer::getSurName))
                .forEach(System.out::println);
    }

    // поиск покупателя по id
    public Customer findById(int id) {
        return customers.stream()
                .filter(customer1 -> customer1.getId() == id)
                .findAny()
                .orElse(null);
    }

    // удаление покупателя
    public void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
    }

    // добавление покупателя
    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        } else {
            System.out.println("Такой покупатель уже существует");
        }
    }

    // изменение данных покупателя
    public void updateCustomer(
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
    public void getCustomersByCreditCardNumber(int start, int end) {
        customers.stream()
                .filter(customer -> Integer.parseInt(customer.getCreditCardNumber()) >= start
                        && Integer.parseInt(customer.getCreditCardNumber()) <= end)
                .forEach(System.out::println);
    }
}
