package tasks.task3;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket("localhost", 4004);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            showMenu();

            String request = "";
            while (clientSocket.isConnected()) {

                request = reader.readLine();

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

    public static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("Нажмите '1' для просмотра дел архива.");
        System.out.println("Нажмите '2' для поиска студентов по факультету.");
        System.out.println("Нажмите '3' для поиска студентов по курсу.");
        System.out.println("Нажмите '4' для добавления нового дела в архив");
        System.out.println("Нажмите '5' для изменения дела.");
        System.out.println("Нажмите '6' для удаления дела.");
    }
}