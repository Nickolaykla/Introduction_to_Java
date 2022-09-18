package tasks.task1.files;

import tasks.task1.models.Book;
import tasks.task1.models.Role;
import tasks.task1.models.User;

import java.io.FileWriter;
import java.io.IOException;

import static tasks.task1.controllers.Library.BOOKS;
import static tasks.task1.controllers.Library.users;

public class FileWorker {
    private static final String BOOKS_TXT =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/books.txt";
    private static final String USERS_TXT =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/users.txt";
    private static final String USERS_EMAIL =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/usersEmail.txt";
    private static final String ADMINS_EMAIL =
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
        try(FileWriter writer = new FileWriter(USERS_EMAIL, true)) {
            for (User user : users) {
                if(user.getRole().equals(Role.DEFAULT_USER)) {
                    writer.write(user.geteMail().getMessages() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addAdminEmailToFile() {
        try(FileWriter writer = new FileWriter(ADMINS_EMAIL, true)) {
            for (User user : users) {
                if(user.getRole().equals(Role.ADMIN)) {
                    writer.write(user.geteMail().getMessages() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}