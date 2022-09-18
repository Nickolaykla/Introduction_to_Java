package basics_of_oop.task5.sweets;

public abstract class Sweet {
    String name;
    double weight;

    public Sweet(String name) {
        this.name = name;
    }

    public abstract void setWeight(double weight);

    @Override
    public String toString() {
        return name + " " + weight + " гр.";
    }
}