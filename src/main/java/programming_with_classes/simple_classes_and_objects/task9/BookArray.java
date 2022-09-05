package programming_with_classes.simple_classes_and_objects.task9;

import java.util.Arrays;

public class BookArray {
    private Book[] books;

    public BookArray(Book[] books) {
        this.books = books;
    }

    public void getBooksByAuthor(String author) {
        if(author != null) {
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println(book);
                }
            }
        } else System.out.println("Неверные данные");
    }

    public void getBooksByPublisher(String publisher) {
        if (publisher != null) {
            Arrays.stream(books)
                    .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                    .forEach(System.out::println);
        } else System.out.println("Неверные данные");
    }

    public void getBooksAfterSomeYear(int year) {
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