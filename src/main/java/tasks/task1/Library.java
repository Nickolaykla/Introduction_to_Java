package tasks.task1;

import tasks.task1.books.Book;
import tasks.task1.books.BookType;
import tasks.task1.roles.Administrator;
import tasks.task1.roles.Logging;
import tasks.task1.roles.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static tasks.task1.books.BookType.*;
import static tasks.task1.roles.Logging.READER;

/*
Создать консольное приложение "Учёт книг в домашней библиотеке".
    - Система учитывает книги как в электронном, так и в бумажном варианте.
    - Существующие роли: пользователь, администратор.
    - Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
    - Администратор может модифицировать каталог.
    - *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям
    - **При просмотре каталога желательно реализовать постраничный просмотр
    - ***Пользователь может предложить добавить книгу в библиотеку, переслав её администратору на e-mail.
    - Каталог книг хранится в текстовом файле.
    - Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде.
*/
public class Library {
    public static final List<Book> BOOKS = new ArrayList<>();
    private static String path = "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/books/books.txt";
    private static User user = new User();
    private static Administrator admin = new Administrator();

    static {
        Book book1 = new Book(BOOK, "Достоевский Ф.М.", "Бесы", 700);
        Book book2 = new Book(E_BOOK, "Достоевский Ф.М.", "Братья Карамазовы", 950);
        Book book3 = new Book(BOOK, "Толстой Л.Н.", "Воскресение", 400);
        Book book4 = new Book(BOOK, "Толстой Л.Н.", "Война и мир", 1400);
        Book book5 = new Book(E_BOOK, "Гоголь Н.В.", "Воскресение", 400);

        Collections.addAll(BOOKS, book1, book2, book3, book4, book5);
        BOOKS.forEach(Library::addBooksToFile);
    }

    public static void addBooksToFile(Book book) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(book + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void refreshBooksInLibrary() {
        try(FileWriter writer = new FileWriter(path)) {
            for (Book book : BOOKS) {
                writer.write(book + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                        userMenu();
                        break;
                    case 2:
                        Logging.logIn();
                        userMenu();
                        break;
                    default:
                        throw new IllegalArgumentException("Что-то пошло не так.");
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
        int num = -1;
        while (num != 0) {
            try {
                num = Integer.parseInt(READER.readLine());
                switch (num) {
                    case 0:
                        startMenu();
                        break;
                    case 1:
                        user.viewBooks();
                        break;
                    case 2:
                        String name = READER.readLine();
                        System.out.println(user.findBooks(name));
                        break;
                    case 3:
                        System.out.println("Введите автора, название и количество страниц:");
                        String auth = READER.readLine();
                        String nam = READER.readLine();
                        user.offerBook(new Book(auth, nam));
                    default: throw new IllegalArgumentException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public static void adminMenu() {
        System.out.println("Для выхода нажмите '0'");
        System.out.println("Для просмотра книг нажмите '1'");
        System.out.println("Для поиска книги нажмите '2'");
        System.out.println("Для добавления книги нажмите '3'");
        System.out.println("Для удаления книги нажмите '4'");

        int num = -1;
        while (num != 0) {
            try {
                num = Integer.parseInt(READER.readLine());
                switch (num) {
                    case 0:
                        startMenu();
                        break;
                    case 1:
                        user.viewBooks();
                    case 2:
                        String name = READER.readLine();
                        System.out.println(user.findBooks(name));
                        break;
                    case 3:
                        System.out.println("Введите тип книги(E_BOOK, BOOK):");
                        String type = READER.readLine();
                        System.out.println("Введите автора книги:");
                        String author = READER.readLine();
                        System.out.println("Введите название книги:");
                        String bookName = READER.readLine();
                        System.out.println("Введите количество страниц:");
                        int pages = Integer.parseInt(READER.readLine());
                        Book book = new Book(BookType.valueOf(type), author, bookName, pages);
                        admin.addBook(book);
                        admin.notifyUsers(book);
                    case 4:
                        int id = Integer.parseInt(READER.readLine());
                        admin.deleteBook(id);
                        System.out.println("Книга была убрана из библиотеки:");
                        admin.notifyUsers(BOOKS.get(id));
                    default: throw new IllegalArgumentException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}