package basics_of_oop.task5;

import static basics_of_oop.task5.box.Box.*;

public class GiftRunner {
    public static void main(String[] args) {
        Gift gift = new Gift();
        gift.addCandy(100);
        gift.addTurkishDelight(600);
        gift.addChocolate(400);

        gift.setBox(CARTON);

        System.out.println(gift);

        Gift gift2 = new Gift();
        gift2.addCandy(1000);
        gift2.addTurkishDelight(3000);
        gift2.setBox(GIFT_BAG);

        System.out.println(gift2);
    }
}