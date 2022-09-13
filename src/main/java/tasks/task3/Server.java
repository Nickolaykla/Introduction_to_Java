package tasks.task3;

/*
Создайте клиент-серверное приложение "Архив".
 */

import tasks.task3.controller.Archive;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   static Archive archive = new Archive();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(4004);
             Socket clientSocket = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            while (true) {
                String word = in.readLine();
                if (word.equals("exit")) break;

                String result = doResponse(word);
                out.write(result + "\n");
                out.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String doResponse(String word) {
        String result = "";
        if (word != null) {
            switch (word) {
                case "1":
                    result = archive.getStudentList();
            }
        } else throw new IllegalArgumentException("Некорректные данные");
        return result;
    }
}