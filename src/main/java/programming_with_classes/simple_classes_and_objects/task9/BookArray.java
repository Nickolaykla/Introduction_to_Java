package programming_with_classes.simple_classes_and_objects.task9;

import java.util.Arrays;

public class BookArray {
    private Book[] books;

    public BookArray(Book[] books) {
        if (books != null) {
            this.books = books;
        }
    }

    public Book[] getBooksByAuthor(String author) {
        return Arrays.stream(books)
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toArray(Book[]::new);
    }

    public Book[] getBooksByPublisher(String publisher) {
        return Arrays.stream(books)
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .toArray(Book[]::new);
    }

    public Book[] getBooksAfterSomeYear(int year) {
        if(year <= 0) throw new IllegalArgumentException("Некорректно задан год");
       return Arrays.stream(books)
               .filter(book -> book.getYearOfPublish() > year)
               .toArray(Book[]::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Book book : books)
            sb.append(book).append("\n");
        return sb.toString();
    }
}