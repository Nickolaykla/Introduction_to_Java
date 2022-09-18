package basics_of_oop.task5.sweets;

public class Waffles extends Sweet {

    public Waffles() {
        super("Вафли");
    }

    @Override
    public void setWeight(double weight) {
        if (weight > 0) {
            super.weight = weight;
        }
    }
}