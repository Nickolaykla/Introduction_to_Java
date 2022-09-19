package tasks.task1.controllers;

import tasks.task1.models.*;

import java.io.*;
import java.util.List;

import static tasks.task1.LibraryMenu.BOOKS;
import static tasks.task1.LibraryMenu.users;

public class FileWorker {
    public static final String BOOKS_TXT =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/books.txt";
    public static final String USERS_TXT =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/users.txt";
    public static final String USERS_EMAIL =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/usersEmail.txt";
    public static final String ADMINS_EMAIL =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/adminsEmail.txt";


    // добавление книги в файл
    public static void addBooksToFile(Book book, String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(book.getType()).append(", ")
                    .append(book.getAuthor()).append(", ").append(book.getBookName())
                    .append(", ").append(book.getPages()).append("\n");
            writer.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // метод для перезаписи книг в файл после удаления
    public static void writeBooksToFile(String path, List<Book> books) {
        try (FileWriter writer = new FileWriter(path)) {
            StringBuilder sb = new StringBuilder();
            for (Book book : books) {
                writer.write(
                        sb.append(book.getType()).append(", ")
                                .append(book.getAuthor()).append(", ").append(book.getBookName())
                                .append(", ").append(book.getPages()).append("\n").toString()
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // добавление данных пользователя в файл
    public static void addUserToFile(User user, String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write("\n" + user.getName() + ", " + user.geteMail().getEmail() +
                    ", " + user.getPassword() + ", " + user.getRole());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // запись сообщений с почты пользователей в файл
    public static void addUserEmailToFile() {
        try (FileWriter writer = new FileWriter(USERS_EMAIL, true)) {

            for (User user : users) {
                if (user.getRole().equals(Role.DEFAULT_USER)) {
                    writer.write(user.geteMail().getMessages().get(user.geteMail().getMessages().size() - 1) + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // запись сообщений с почты админов в файл
    public static void addAdminEmailToFile() {
        try (FileWriter writer = new FileWriter(ADMINS_EMAIL, true)) {
            for (User user : users) {
                if (user.getRole().equals(Role.ADMIN)) {
                    writer.write("\n" + user.geteMail().getMessages() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // считываем книги из файла и добавляем в коллекцию
    public static void readBooksFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String lines;
            while ((lines = reader.readLine()) != null) {
                String[] line = lines.split(", ");
                Book book = new Book();
                book.setType(BookType.valueOf(line[0].trim()));
                book.setAuthor(line[1].trim());
                book.setBookName(line[2].trim());
                book.setPages(Integer.parseInt(line[3].trim()));

                BOOKS.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // считываем пользователей из файла
    public static void readUsersFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String lines;
            while ((lines = reader.readLine()) != null) {
                String[] line = lines.split(", ");
                User user = new User();
                user.setName(line[0]);
                user.seteMail(new Email(line[1]));
                user.setPassword(line[2]);
                user.setRole(Role.valueOf(line[3]));

                users.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}