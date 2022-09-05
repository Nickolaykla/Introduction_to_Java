package programming_with_classes.task9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookArray {
    public static void main(String[] args) {
        Book book1 = new Book(0, "Анна Каренина", "Толстой Л.Н.", "АСТ", 2018, 864, 20.45, "soft");
        Book book2 = new Book(1, "Воскресение", "Толстой Л.Н", "Азбука", 2021, 576, 16.69, "hard");
        Book book3 = new Book(2, "Братья Карамазовы", "Достоевский Ф.М.", "Азбука", 2013, 832, 16.69, "hard");
        Book book4 = new Book(3, "Идиот", "Достоевский Ф.М.", "Эксмо", 2016, 640, 20.49, "soft");
        Book book5 = new Book(4, "На дне", "Горький М.", "АСТ", 2022, 320, 17.43, "hard");

        Book[] books = {book1, book2, book3, book4, book5};
        BookArray bookArray = new BookArray();
        System.out.println("Книги, по заданному автору:");
        bookArray.getBooksByAuthor(books, "достоевский ф.м.");

        System.out.println("Книги, по заданному издательству:");
        bookArray.getBooksByPublisher(books, "аст");

        System.out.println("Книги, выпущенные после заданного года:");
        bookArray.getBooksAfterSomeYear(books, 2020);

    }

    public void getBooksByAuthor(Book[] books, String author) {
        if(author != null) {
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println(book);
                }
            }
        } System.out.println("Неверные данные");
    }
    public void getBooksByPublisher(Book[] books, String publisher) {
        if (publisher != null) {
            Arrays.stream(books)
                    .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                    .forEach(System.out::println);
        } else System.out.println("Неверные данные");
    }
    public void getBooksAfterSomeYear(Book[] books, int year) {
        if(year > 0) {
            for (Book book : books) {
                if (book.getYearOfPublish() >= year) {
                    System.out.println(book);
                }
            }
        } else {
            System.out.println("Неверные данные");
        }
    }
}