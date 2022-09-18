package basics_of_oop.task2;

import java.util.List;
import java.util.Optional;

/*
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать
покупку из нескольких товаров.
*/

public class Payment {
    private static int id = 1;
    private List<Product> products;

    public Payment(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> makeOrder(int id) {
        return products.stream()
                .filter(product1 -> product1.getId() == id)
                .findAny();
    }

    public double sumOfOrder(List<Product> list) {
        return list.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    class Product {
        private String name;
        private double price;
        private int id;

        public Product(String name, double price) {
            id = Payment.id++;
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (!name.isEmpty()) {
                this.name = name;
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

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}