package basics_of_oop.task5.sweets;

public class SweetFactory {
    public static Sweet createSweet(SweetType type) {
        switch (type) {
            case CHOCOLATE:
                return new Chocolate();
            case WAFFLES:
                return new Waffles();
            case TURKISH_DELIGHT:
                return new TurkishDelight();
            default: throw new IllegalArgumentException();
        }
    }
}