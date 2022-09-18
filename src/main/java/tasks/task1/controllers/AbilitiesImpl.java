package tasks.task1.controllers;

import tasks.task1.models.Book;
import tasks.task1.models.Role;
import tasks.task1.models.User;

import java.util.List;
import java.util.stream.Collectors;

import static tasks.task1.Library.*;

public class AbilitiesImpl implements AllAbilities {
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

    // отправляем администраторам уведомление с просьбой добавить книгу
    @Override
    public void offerBook(Book book) {
        List<User> admins = getUsersByRole(Role.ADMIN);
        for (User user : admins) {
            user.geteMail().getMessages().add(user.getName() + " Предлагаю добавить в библиотеку следующую книгу + \n" +
                    book.toString());
        }
    }

    @Override
    public void addBook(Book book) {
        if (!isBookExist(book)) {
            BOOKS.add(book);
            addBooksToFile(book);
        } else System.out.println("Книга уже есть в библиотеке.");
    }

    private boolean isBookExist(Book book) {
        for(Book b : BOOKS) {
            if(b.equals(book)) return true;
        }
        return false;
    }

    @Override
    public void deleteBook(int id) {
        BOOKS.remove(id);
        refreshBooksInLibrary();
    }

    // отправляем пользователям уведомление на e-mail и новой книге
    @Override
    public void notifyUsers(Book book) {
        List<User> usersToNotify = getUsersByRole(Role.DEFAULT_USER);
        for (User user : usersToNotify) {
            user.geteMail().getMessages().add(user.getName() + "Добавлена новая книга:" + "\n" + book.toString());
        }
    }

    // получаем список пользователей в зависимости от роли
    private List<User> getUsersByRole(Role role) {
        return users.stream()
                .filter(user -> user.getRole().equals(role))
                .collect(Collectors.toList());
    }
}