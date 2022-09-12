package tasks.task1.roles;

import tasks.task1.books.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static tasks.task1.Library.BOOKS;

public class User implements UserAbilities {
    private String name;
    private String eMail;
    private String password;
    public static List<User> users = new ArrayList<>();

    public User(String name, String eMail, String password) {
        this.name = name;
        this.eMail = eMail;
        this.password = encryptPassword(password);
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return false;
    }
    public static String encryptPassword(String password) {
        try {
            MessageDigest passw = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            byte[] bytes = passw.digest(password.getBytes());
            for(byte b : bytes) {
                sb.append(b);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addUserToFile(User user) {
        String path = "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/roles/users.txt";
        try(FileWriter writer = new FileWriter(path, true)) {
            writer.write(user + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public void offerBook(Book book) {
        System.out.println("Предлагаю добавить данную книгу в каталог!");
        System.out.println(book.getAuthor() + " " + book.getBookName());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;

        return password.equals(user.password) && isAdmin() == user.isAdmin();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + Boolean.hashCode(isAdmin());
        return result;
    }
}