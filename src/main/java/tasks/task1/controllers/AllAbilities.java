package tasks.task1.controllers;

import tasks.task1.models.Book;

public interface AllAbilities {
    void viewBooks();
    Book findBooks(String name);
    void offerBook(Book book);
    void addBook(Book book);
    void deleteBook(int id);
    void notifyUsers(Book book);
}
