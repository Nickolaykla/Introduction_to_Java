package tasks.task1.roles;

import tasks.task1.books.Book;

import java.util.List;

import static tasks.task1.Library.BOOKS;

public class User implements UserAbilities {
    private String name;
    private String eMail;
    private String password;
    private List<User> users;

    public User(String name, String eMail, String password) {
        this.name = name;
        this.eMail = eMail;
        this.password = password;
    }

    public User() {
    }

    public List<User> getUsers() {
        return users;
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

    public void registerUser(String name, String eMail, String password) {
        User user = new User(name, eMail, password);
        users.add(user);
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
}