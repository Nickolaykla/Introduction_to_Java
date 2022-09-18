package tasks.task1.controllers;

import tasks.task1.Library;
import tasks.task1.models.Email;
import tasks.task1.models.Role;
import tasks.task1.models.User;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static tasks.task1.Library.users;

public class Logging {
    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void logIn() {
        try {
            System.out.println("Введите имя пользователя:");
            String name = READER.readLine();
            System.out.println("Введите email:");
            Email eMail = new Email(READER.readLine());
            System.out.println("Введите пароль:");
            String password = READER.readLine();
            User user = new User(name, eMail, password);
            User foundUser = findUser(user);
            if (foundUser != null) {
                if (isAdmin(foundUser)) {
                    Library.adminMenu();
                } else {
                    Library.userMenu();
                }
            } else {
                System.out.println("Неверно задан логин или пароль");
                Library.startMenu();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static User findUser(User user) {
        for (User us : users) {
            if (us.equals(user)) return us;
        }
        return null;
    }

    private static boolean isAdmin(User user) {
        return user.getRole().equals(Role.ADMIN);
    }

    public static void register() {
        try {
            System.out.println("Введите имя пользователя:");
            String name = READER.readLine();
            System.out.println("Введите email:");
            Email eMail = new Email(READER.readLine());
            System.out.println("Введите пароль:");
            String password = READER.readLine();
            User user = new User(name, eMail, password);
            users.add(user);
            addUserToFile(user);
            Library.userMenu();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addUserToFile(User user) {
        String path = "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task1/files/users.txt";
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(user + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest passw = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            byte[] bytes = passw.digest(password.getBytes());
            for (byte b : bytes) {
                sb.append((char) b);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}