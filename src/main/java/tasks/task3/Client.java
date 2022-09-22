package tasks.task3;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket("localhost", 4004);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            System.out.println(startMenu());


            String request = "";
            while (clientSocket.isConnected()) {

                request = reader.readLine();

                if (request.equalsIgnoreCase("exit")) break;

                out.write(request + "\n");
                out.flush();

                do {
                    System.out.println(in.readLine());
                } while (in.ready());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static String startMenu() {
        return "Выберите действие:" + "\n" +
                "Нажмите '1' для входа." + "\n" +
                "Нажмите '2' для регистрации." + "\n" +
                "Для выхода введите 'exit'" + "\n";
    }

    public static String showUserMenu() {
        return "Выберите действие:" + "\n" +
                "Нажмите '1' для просмотра дел архива." + "\n" +
                "Нажмите '2' для поиска студентов по факультету." + "\n" +
                "Нажмите '3' для поиска студентов по курсу." + "\n";
    }

    public static String showAdminMenu() {
        return "Выберите действие:" + "\n" +
                "Нажмите '1' для просмотра дел архива." + "\n" +
                "Нажмите '2' для поиска студентов по факультету." + "\n" +
                "Нажмите '3' для поиска студентов по курсу." + "\n" +
                "Нажмите '4' для поиска студентов по группе." + "\n" +
                "Нажмите '5' для изменения дела." + "\n" +
                "Нажмите '6' для удаления дела." + "\n" +
                "Нажмите '7' для добавления нового дела в архив" + "\n";
    }
}