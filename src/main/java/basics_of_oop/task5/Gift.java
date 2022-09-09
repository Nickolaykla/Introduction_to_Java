package basics_of_oop.task5;

import basics_of_oop.task5.box.Box;
import basics_of_oop.task5.sweets.Sweet;
import basics_of_oop.task5.sweets.SweetFactory;

import java.util.ArrayList;
import java.util.List;

import static basics_of_oop.task5.sweets.SweetType.*;

public class Gift {
    private Box box = new Box();
    private List<Sweet> sweets = new ArrayList<>();

    public void addChocolate(double weight) {
        Sweet chocko = SweetFactory.createSweet(CHOCOLATE);
        if (weight > 0) {
            chocko.setWeight(weight);
            sweets.add(chocko);
        } else throw new IllegalArgumentException();
    }
    public void addMarmalade(double weight) {
        Sweet marmal = SweetFactory.createSweet(MARMALADE);
        if (weight > 0) {
            marmal.setWeight(weight);
            sweets.add(marmal);
        } else throw new IllegalArgumentException();
    }

    public void addCandy(double weight) {
        Sweet candy = SweetFactory.createSweet(CANDY);
        if (weight > 0) {
            candy.setWeight(weight);
            sweets.add(candy);
        } else throw new IllegalArgumentException();
    }
    public void chooseBoxType(String type) {
        if (type != null) {
            box.setType(type);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Подарок{упаковка = ").append(box);
        for (Sweet sweet : sweets) {
            sb.append(", ").append(sweet);
        }
        sb.append("}");
        return sb.toString();
    }
}