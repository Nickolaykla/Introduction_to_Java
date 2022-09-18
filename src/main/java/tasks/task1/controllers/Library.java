package tasks.task1.controllers;

import tasks.task1.files.FileWorker;
import tasks.task1.models.Book;
import tasks.task1.models.BookType;
import tasks.task1.models.Email;
import tasks.task1.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static tasks.task1.models.BookType.*;
import static tasks.task1.controllers.Logging.READER;
import static tasks.task1.models.Role.*;

public class Library {
    public static final List<Book> BOOKS = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    private static final User user = new User();

    static {
        Book book1 = new Book(BOOK, "Достоевский Ф.М.", "Бесы", 700);
        Book book2 = new Book(E_BOOK, "Достоевский Ф.М.", "Братья Карамазовы", 950);
        Book book3 = new Book(BOOK, "Толстой Л.Н.", "Воскресение", 400);
        Book book4 = new Book(BOOK, "Толстой Л.Н.", "Война и мир", 1400);
        Book book5 = new Book(E_BOOK, "Гоголь Н.В.", "Мёртвые души", 500);

        Collections.addAll(BOOKS, book1, book2, book3, book4, book5);
        BOOKS.forEach(FileWorker::addBooksToFile);

        User user1 = new User("Vova", new Email("vova@gmail.com"), "1", DEFAULT_USER);
        User user2 = new User("Inokentiy", new Email("inok@gmail.com"), "12", ADMIN);
        User user3 = new User("Nataly", new Email("nataska@mail.ru"), "123", DEFAULT_USER);

        Collections.addAll(users, user1, user2, user3);
        users.forEach(FileWorker::addUserToFile);
    }


    public static void startMenu() {
        System.out.println("Для выхода нажмите '0'");
        System.out.println("Для регистрации нажмите '1'");
        System.out.println("Для входа нажмите '2'");

        int num = -1;
        while (num != 0) {
            try {
                num = Integer.parseInt(READER.readLine());
                switch (num) {
                    case 0:
                        System.out.println("Всего хорошего!");
                        break;
                    case 1:
                        Logging.register();
                        break;
                    case 2:
                        Logging.logIn();
                        break;
                    default:
                        System.out.println("Введен неверный параметр");
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void userMenu() {
        System.out.println("Для выхода нажмите '0'");
        System.out.println("Для просмотра книг нажмите '1'");
        System.out.println("Для поиска книги нажмите '2'");
        System.out.println("Для предложения книги нажмите '3'");
        userActions();
    }

    public static void adminMenu() {
        System.out.println("Для выхода нажмите '0'");
        System.out.println("Для просмотра книг нажмите '1'");
        System.out.println("Для поиска книги нажмите '2'");
        System.out.println("Для добавления книги нажмите '3'");
        System.out.println("Для удаления книги нажмите '4'");
        adminActions();
    }

    public static void userActions() {
        int num = -1;
        while (num != 0) {
            try {
                num = Integer.parseInt(READER.readLine());
                switch (num) {
                    case 0:
                        startMenu();
                        break;
                    case 1:
                        user.getAbility().viewBooks();
                        break;
                    case 2:
                        String name = READER.readLine();
                        System.out.println(user.getAbility().findBooks(name));
                        break;
                    case 3:
                        Book book = bookAddOffer();
                        user.getAbility().offerBook(book);
                        break;
                    default:
                        System.out.println("Введен неверный параметр");
                        userMenu();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void adminActions() {
        int num = -1;
        while (num != 0) {
            try {
                num = Integer.parseInt(READER.readLine());
                switch (num) {
                    case 0:
                        startMenu();
                        break;
                    case 1:
                        user.getAbility().viewBooks();
                        break;
                    case 2:
                        System.out.println("Введите название книги:");
                        String name = READER.readLine();
                        System.out.println(user.getAbility().findBooks(name));
                        break;
                    case 3:
                        Book book1 = bookAddOffer();
                        user.getAbility().addBook(book1);
                        user.getAbility().notifyUsers(book1, "Добавлена");
                        break;
                    case 4:
                        int id = Integer.parseInt(READER.readLine());
                        user.getAbility().deleteBook(id);
                        System.out.println("Книга была убрана из библиотеки:");
                        user.getAbility().notifyUsers(BOOKS.get(id), "Удалена");
                        break;
                    default:
                        System.out.println("Введен неверный параметр");
                        adminMenu();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static Book bookAddOffer() {
        try {
            System.out.println("Введите тип книги(E_BOOK, BOOK):");
            String type = READER.readLine();
            System.out.println("Введите автора книги:");
            String author = READER.readLine();
            System.out.println("Введите название книги:");
            String bookName = READER.readLine();
            System.out.println("Введите количество страниц:");
            int pages = Integer.parseInt(READER.readLine());
            Book book = new Book();
            book.setType(BookType.valueOf(type));
            book.setAuthor(author);
            book.setBookName(bookName);
            book.setPages(pages);
            return book;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}