package programming_with_classes.simple_classes_and_objects.task8;
/*
Создать класс Customer. Определить конструкторы, set- и get- методы и метод toString(). Создать второй класс,
агрегирующий массив типа Customer, с подходящими конструкторами и методами. Задать критерии выбора данных и
вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
а) список покупателей в алфавитном порядке;
б) список покупателей, у которых номер кредитной карточки находится в заданном интервале
* */
public class Customer {
    private int id;
    private String surName;
    private String firstName;
    private String lastName;
    private String address;
    private String creditCardNumber;
    private String bankAccountNumber;

    public Customer(int id, String surName, String firstName, String lastName,
                    String address, String creditCardNumber, String bankAccountNumber) {
        if (id >= 0 && surName != null && firstName != null && lastName != null &&
                address != null && creditCardNumber.length() == 6 && bankAccountNumber.length() == 6) {
            this.id = id;
            this.surName = surName;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.creditCardNumber = creditCardNumber;
            this.bankAccountNumber = bankAccountNumber;
        } else {
            System.out.println("Заданы неверные данные");
            throw new IllegalArgumentException();
        }
    }

    public int getId() {
        return id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if (!surName.isEmpty()) {
            this.surName = surName;
        } else {
            System.out.println("Некорректные данные");
            throw new IllegalArgumentException();
        }
    }

    public void setFirstName(String firstName) {
        if (!firstName.isEmpty()) {
            this.firstName = firstName;
        } else {
            System.out.println("Некорректные данные");
            throw new IllegalArgumentException();
        }
    }

    public void setLastName(String lastName) {
        if (!lastName.isEmpty()) {
            this.lastName = lastName;
        } else {
            System.out.println("Некорректные данные");
            throw new IllegalArgumentException();
        }
    }

    public void setAddress(String address) {
        if (!address.isEmpty()) {
            this.address = address;
        } else {
            System.out.println("Некорректные данные");
            throw new IllegalArgumentException();
        }
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        if (creditCardNumber.length() == 6) {
            this.creditCardNumber = creditCardNumber;
        } else {
            System.out.println("Некорректные данные");
            throw new IllegalArgumentException();
        }
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        if (bankAccountNumber.length() == 6) {
            this.bankAccountNumber = bankAccountNumber;
        } else {
            System.out.println("Некорректные данные");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", bankAccountNumber=" + bankAccountNumber +
                '}';
    }
}