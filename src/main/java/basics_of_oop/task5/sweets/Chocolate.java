package basics_of_oop.task5.sweets;

public class Chocolate extends Sweet {

    public Chocolate() {
        super("Шоколад");
    }

    @Override
    public void setWeight(double weight) {
        if (weight > 0) {
            super.weight = weight;
        }
    }
}