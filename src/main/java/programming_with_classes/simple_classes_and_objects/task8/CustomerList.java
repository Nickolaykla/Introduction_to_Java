package programming_with_classes.simple_classes_and_objects.task8;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerList {

    private List<Customer> customers;

    public CustomerList(List<Customer> customers) {
        if (!customers.isEmpty()) {
            this.customers = customers;
        }
    }

    // Список всех покупателей
    public List<Customer> getCustomers() {
        return customers;
    }

    // Сортировка по фамилии
    public List<Customer> getCustomersSortedBySurname() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getSurName))
                .collect(Collectors.toList());
    }

    // поиск покупателя по id
    public Customer findById(int id) {
        return customers.stream()
                .filter(customer1 -> customer1.getCustomerId() == id)
                .findAny()
                .orElse(null);
    }

    // удаление покупателя
    public void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getCustomerId() == id);
    }

    // добавление покупателя
    public void addCustomer(Customer customer) {
        if(!checkExistance(customers, customer)) {
            customers.add(customer);
        } else System.out.println("Такой покупатель уже есть в списке.");
    }

    // Проверяем по номеру кредитной карты и банковскому счёту наличие покупателя в списке
    public boolean checkExistance(List<Customer> list, Customer customer) {
        for (Customer cust : customers) {
            if(cust.getBankAccountNumber().equals(customer.getBankAccountNumber())
                    && cust.getCreditCardNumber().equals(customer.getCreditCardNumber())) {
                return true;
            }
        }
        return false;
    }

    // изменение данных покупателя
    public void updateCustomer(
            Customer customer, int id, String surName, String firstName, String lastName,
            String address, String creditCardNumber, String bankAccountNumber) {

        if (customer.getCustomerId() != id) {
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
    public List<Customer> getCustomersByCreditCardNumber(int start, int end) {
        return customers.stream()
                .filter(customer -> Integer.parseInt(customer.getCreditCardNumber()) >= start
                        && Integer.parseInt(customer.getCreditCardNumber()) <= end)
                .collect(Collectors.toList());
    }
}