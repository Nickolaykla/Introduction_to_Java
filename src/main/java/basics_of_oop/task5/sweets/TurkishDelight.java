package basics_of_oop.task5.sweets;

public class TurkishDelight extends Sweet {

    public TurkishDelight() {
        super("Рахат-лукум");
    }

    @Override
    public void setWeight(double weight) {
        if (weight > 0) {
            super.weight = weight;
        }
    }
}