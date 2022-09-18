package basics_of_oop.task4;

public class Treasure {
    private static int treasureId;
    private String name;
    private double price;
    private int id;

    public Treasure(String name, double price) {
        if (name != null && price > 0) {
            this.id = ++treasureId;
            this.name = name;
            this.price = price;
        } else throw new IllegalArgumentException("Введены некорректные данные.");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
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

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}