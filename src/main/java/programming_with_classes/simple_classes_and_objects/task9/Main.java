package programming_with_classes.simple_classes_and_objects.task9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(0, "Анна Каренина", "Толстой Л.Н.", "АСТ",
                2018, 864, 20.45, "soft");
        Book book2 = new Book(1, "Воскресение", "Толстой Л.Н", "Азбука",
                2021, 576, 16.69, "hard");
        Book book3 = new Book(2, "Братья Карамазовы", "Достоевский Ф.М.", "Азбука",
                2013, 832, 16.69, "hard");
        Book book4 = new Book(3, "Идиот", "Достоевский Ф.М.", "Эксмо",
                2016, 640, 20.49, "soft");
        Book book5 = new Book(4, "На дне", "Горький М.", "АСТ",
                2022, 320, 17.43, "hard");

        Book[] books = {book1, book2, book3, book4, book5};
        BookArray bookArray = new BookArray(books);
//        System.out.println("Книги, по заданному автору:");
//        bookArray.getBooksByAuthor("достоевский ф.м.");
        System.out.println(bookArray);

        System.out.println("Книги, по заданному издательству:");
        System.out.println(Arrays.toString(bookArray.getBooksByPublisher("аст")));

//        System.out.println("Книги, выпущенные после заданного года:");
//        bookArray.getBooksAfterSomeYear(2020);
    }
}
