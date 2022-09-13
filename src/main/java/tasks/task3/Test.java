package tasks.task3;

import tasks.task3.controller.Archive;

import java.net.Socket;

public class Test {
   static Archive archive = new Archive();
   static Socket socket;

    public static void main(String[] args) {
        System.out.println(archive.getStudentList());
    }
}
