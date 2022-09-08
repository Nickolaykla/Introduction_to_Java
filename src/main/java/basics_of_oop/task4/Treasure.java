package basics_of_oop.task4;

public class Treasure {
    private static int treasureId;
    private String name;
    private double price;
    private int id;

    public Treasure(String name, double price) {
        this.id = ++treasureId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
