package tasks.task1.controllers;

import tasks.task1.models.*;

import java.io.*;

import static tasks.task1.Library.BOOKS;
import static tasks.task1.Library.users;

public class FileWorker {
    public static final String BOOKS_TXT =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/books.txt";
    public static final String USERS_TXT =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/users.txt";
    public static final String USERS_EMAIL =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/usersEmail.txt";
    public static final String ADMINS_EMAIL =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/adminsEmail.txt";


    public static void addBooksToFile(Book book) {
        try (FileWriter writer = new FileWriter(BOOKS_TXT, true)) {
            writer.write(book + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void refreshBooksInLibrary() {
        try (FileWriter writer = new FileWriter(BOOKS_TXT)) {
            for (Book book : BOOKS) {
                writer.write(book + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addUserToFile(User user) {
        try (FileWriter writer = new FileWriter(USERS_TXT, true)) {
            writer.write(user + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addUserEmailToFile() {
        try (FileWriter writer = new FileWriter(USERS_EMAIL, true)) {
            for (User user : users) {
                if (user.getRole().equals(Role.DEFAULT_USER)) {
                    writer.write(user.geteMail().getMessages() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addAdminEmailToFile() {
        try (FileWriter writer = new FileWriter(ADMINS_EMAIL, true)) {
            for (User user : users) {
                if (user.getRole().equals(Role.ADMIN)) {
                    writer.write(user.geteMail().getMessages() + "\n");
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
                book.setId(Integer.parseInt(line[0].trim()));
                book.setType(BookType.valueOf(line[1].trim()));
                book.setAuthor(line[2].trim());
                book.setBookName(line[3].trim());
                book.setPages(Integer.parseInt(line[4].trim()));

                BOOKS.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readUsersFromFile(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
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