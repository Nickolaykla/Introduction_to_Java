package basics_of_oop.task5;

public class GiftRunner {
    public static void main(String[] args) {
        Gift gift = new Gift();
        gift.addCandy(123);
        gift.addChocolate(500);
        gift.addMarmalade(300);
        gift.chooseBoxType("Carton");
        System.out.println(gift);
    }
}
