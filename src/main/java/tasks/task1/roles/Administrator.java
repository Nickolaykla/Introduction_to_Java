package tasks.task1.roles;

import tasks.task1.books.Book;

import java.util.ArrayList;
import java.util.List;

import static tasks.task1.Library.BOOKS;

public class Administrator extends User implements AdminAbilities {
    List<Administrator> admins = new ArrayList<>();

    public void registerAdmin(String name, String eMail, String password) {
        Administrator administrator = new Administrator();
        administrator.setName(name);
        administrator.seteMail(eMail);
        administrator.setPassword(password);
        admins.add(administrator);
    }

    @Override
    public void addBook(Book book) {
        if (!BOOKS.contains(book)) {
            BOOKS.add(book);
        } else System.out.println("Книга уже есть в библиотеке.");
    }

    @Override
    public void deleteBook(int id) {
        BOOKS.remove(id);
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
