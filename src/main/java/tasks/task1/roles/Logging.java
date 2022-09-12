package tasks.task1.roles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Logging {

    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void logIn() {
        try {
            System.out.println("Введите имя пользователя:");
            String name = READER.readLine();
            System.out.println("Введите email:");
            String eMail = READER.readLine();
            System.out.println("Введите пароль:");
            String password = READER.readLine();
            User user = new User(name, eMail, password);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void register() {
        try {
            System.out.println("Введите имя пользователя:");
            String name = READER.readLine();
            System.out.println("Введите email:");
            String eMail = READER.readLine();
            System.out.println("Введите пароль:");
            String password = READER.readLine();
            User user = new User(name, eMail, password);
            User.users.add(user);
            User.addUserToFile(user);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
