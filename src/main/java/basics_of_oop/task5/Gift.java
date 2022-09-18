package basics_of_oop.task5;

import basics_of_oop.task5.box.Box;
import basics_of_oop.task5.sweets.Sweet;
import basics_of_oop.task5.sweets.SweetFactory;

import java.util.ArrayList;
import java.util.List;

import static basics_of_oop.task5.sweets.SweetType.*;

public class Gift {
    private Box box;
    private List<Sweet> sweets = new ArrayList<>();

    public void addChocolate(double weight) {
        Sweet chocko = SweetFactory.createSweet(CHOCOLATE);
        if (weight > 0) {
            chocko.setWeight(weight);
            sweets.add(chocko);
        } else throw new IllegalArgumentException("Ошибка при добавлении шоколада в подарок!");
    }

    public void addTurkishDelight(double weight) {
        Sweet marmal = SweetFactory.createSweet(TURKISH_DELIGHT);
        if (weight > 0) {
            marmal.setWeight(weight);
            sweets.add(marmal);
        } else throw new IllegalArgumentException("Ошибка при добавлении Рахат-лукума в подарок!");
    }

    public void addCandy(double weight) {
        Sweet candy = SweetFactory.createSweet(WAFFLES);
        if (weight > 0) {
            candy.setWeight(weight);
            sweets.add(candy);
        } else throw new IllegalArgumentException("Ошибка при добавлении вафель в подарок!");
    }

    public void setBox(Box box) {
        this.box = box;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Подарок: упаковка = ").append(box)
                .append(", Сладости: ");
        for (Sweet sweet : sweets) {
            sb.append(sweet).append(" ");
        }
        return sb.toString();
    }
}