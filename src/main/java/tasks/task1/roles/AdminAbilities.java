package tasks.task1.roles;

import tasks.task1.books.Book;

public interface AdminAbilities extends UserAbilities {
    void addBook(Book book);
    void deleteBook(int id);
    void notifyUsers(Book book);
}
