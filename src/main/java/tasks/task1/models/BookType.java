package tasks.task1.models;

public enum BookType {
    BOOK("Бумажная книга"),
    E_BOOK("Электронная книга");

    private String name;

    BookType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
