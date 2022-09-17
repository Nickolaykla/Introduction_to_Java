package programming_with_classes.simple_classes_and_objects.task9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(0, "Анна Каренина", "Толстой Л Н", "АСТ",
                2018, 864, 20.45, "soft");
        Book book2 = new Book(1, "Воскресение", "Толстой Л Н", "Азбука",
                2021, 576, 16.69, "hard");
        Book book3 = new Book(2, "Братья Карамазовы", "Достоевский Ф М", "Азбука",
                2013, 832, 16.69, "hard");
        Book book4 = new Book(3, "Идиот", "Достоевский Ф М", "Эксмо",
                2016, 640, 20.49, "soft");
        Book book5 = new Book(4, "На дне", "Горький М", "АСТ",
                2022, 320, 17.43, "hard");

        Book[] books = {book1, book2, book3, book4, book5};
        BookArray bookArray = new BookArray(books);
        System.out.println("все книги:");
        System.out.println(bookArray);

        System.out.println("Книги по заданному автору:");
        Book[] booksByAuthor = bookArray.getBooksByAuthor("достоевский ф м");
        Arrays.stream(booksByAuthor).forEach(System.out::println);

        System.out.println("\n" + "Книги по заданному издательству:");
        Book[] booksByPublisher = bookArray.getBooksByPublisher("аст");
        Arrays.stream(booksByPublisher).forEach(System.out::println);

        System.out.println("\n" + "Книги, выпущенные после заданного года:");
        Book[] booksAfterYear = bookArray.getBooksAfterSomeYear(2016);
        Arrays.stream(booksAfterYear).forEach(System.out::println);
    }
}