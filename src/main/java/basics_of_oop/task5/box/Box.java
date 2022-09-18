package basics_of_oop.task5.box;

public enum Box {
    CARTON("Картонная упаковка"),
    WRAPPER_PAPER("Бумажная упаковка"),
    GIFT_BAG("Подарочный пакет"),
    FABRIC("Тканевая упаковка");

    final String name;

    Box(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}