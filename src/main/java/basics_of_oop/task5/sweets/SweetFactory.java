package basics_of_oop.task5.sweets;

public class SweetFactory {
    public static Sweet createSweet(SweetType type) {
        switch (type) {
            case CHOCOLATE:
                return new Chocolate();
            case CANDY:
                return new Candy();
            case MARMALADE:
                return new Marmalade();
            default: throw new IllegalArgumentException();
        }
    }
}
