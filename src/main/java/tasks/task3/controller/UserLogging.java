package tasks.task3.controller;

import tasks.task3.Client;
import tasks.task3.model.Role;
import tasks.task3.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class UserLogging {
    private static final String PATH =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task3/data/users.xml";
    public static UserLogging userLogging = new UserLogging();
    private static Role role = Role.USER;

    public UserLogging() {
    }

    public static Role getRole() {
        return role;
    }

    @XmlElement(name = "user")
    private List<User> users = new ArrayList<>();

    public boolean add(User user) {
        return users.add(user);
    }

    public List<User> getAllUsers() {
        return getFromXml().users;
    }

    //считываем данные из xml
    public static UserLogging getFromXml() {
        try (FileReader fr = new FileReader(PATH)) {
            JAXBContext context = JAXBContext.newInstance(UserLogging.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (UserLogging) unmarshaller.unmarshal(fr);
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    // добавляем пользователя в базу
    public static void addToXml(User user) {
        if (!getFromXml().users.isEmpty()) {
            userLogging = getFromXml();
            userLogging.add(user);
        } else userLogging.add(user);

        try (FileWriter fw = new FileWriter(PATH)) {
            JAXBContext jaxb = JAXBContext.newInstance(UserLogging.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(userLogging, fw);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean logIn(BufferedReader in, BufferedWriter out) {
        boolean isLogIn = false;
        try {
            out.write("Введите имя пользователя:" + "\n");
            out.flush();
            String name = in.readLine();
            out.write("Введите пароль:" + "\n");
            out.flush();
            String password = in.readLine();
            User user = new User(name, encryptPassword(password));
            User foundUser = findUser(user);
            System.out.println(foundUser);
            if (foundUser != null) {
                if (isAdmin(foundUser)) {
                    role = Role.ADMIN;
                    out.write(Client.showAdminMenu() + "\n");
                    out.flush();
                } else {
                    out.write(Client.showUserMenu() + "\n");
                    out.flush();
                }
                isLogIn = true;
            } else {
                out.write("Неверно задан логин или пароль" + "\n");
                out.write(Client.startMenu() + "\n");
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return isLogIn;
    }

    //проверяем наличие пользователя
    private static User findUser(User user) {
        for (User us : userLogging.getAllUsers()) {
            if (us.equals(user)) return us;
        }
        return null;
    }

    private static boolean isAdmin(User user) {
        return user.getRole().equals(Role.ADMIN);
    }

    public static void register(BufferedReader in, BufferedWriter out) {
        try {
            out.write("Введите имя пользователя:" + "\n");
            out.flush();
            String name = in.readLine();
            out.write("Введите пароль:" + "\n");
            out.flush();
            String password = in.readLine();
            User user = new User(name, encryptPassword(password));
            addToXml(user);
            out.write(Client.showUserMenu() + "\n");
            out.flush();
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
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}