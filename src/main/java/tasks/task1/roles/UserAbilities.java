package tasks.task1.roles;

import tasks.task1.books.Book;

public interface UserAbilities {
    void viewBooks();
    Book findBooks(String name);
    default void offerBook(Book book) {
    }
}
