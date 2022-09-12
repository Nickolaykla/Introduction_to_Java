package tasks.task1.roles;

import tasks.task1.books.Book;

import static tasks.task1.Library.*;

public class Administrator extends User implements AdminAbilities {

    @Override
    public boolean isAdmin() {
        return true;
    }

    @Override
    public void addBook(Book book) {
        if (!BOOKS.contains(book)) {
            BOOKS.add(book);
            addBooksToFile(book);
        } else System.out.println("Книга уже есть в библиотеке.");
    }

    @Override
    public void deleteBook(int id) {
        BOOKS.remove(id);
        refreshBooksInLibrary();
    }

    @Override
    public void viewBooks() {
        BOOKS.forEach(System.out::println);
    }

    @Override
    public Book findBooks(String name) {
        return BOOKS.stream()
                .filter(book -> book.getBookName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public void notifyUsers(Book book) {
        System.out.println(book);
    }
}
