package tasks.task3;

/*
Создайте клиент-серверное приложение "Архив".
 */

import tasks.task3.controller.StudentList;
import tasks.task3.model.Faculty;
import tasks.task3.model.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    static StudentList studentList = new StudentList();
    static BufferedReader in;
    static BufferedWriter out;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(4004);
             Socket serverSocket = server.accept()) {

            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));


            String request = "";
            String result = "";
            while (serverSocket.isConnected()) {
                request = in.readLine();
                System.out.println(request);
                result = doResponse(request);
                out.write(result + "\n");
                out.flush();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String doResponse(String param) throws IOException {
        String result = "";
        switch (param) {
            case "1":
                result = studentList.getInstance().toString();
                break;
            case "2":
                out.write("Введите факультет(ECONOMICS, ENGINEER, BIOLOGY, PHYSICS:" + "\n");
                out.flush();
                List<Student> res2 = studentList.getStudentsByFaculty(Faculty.valueOf(in.readLine()));
                result = studentList.response(res2);
                break;
            case "3":
                out.write("Введите курс (1-5):" + "\n");
                out.flush();
                List<Student> res3 = studentList.getStudentsByCourse(Integer.parseInt(in.readLine()));
                result = studentList.response(res3);
                break;
            case "4":
                StudentList.addToXml(studentInit());
                break;
            case "5":
                out.write("Введите id студента:");
                out.flush();
                int studId = Integer.parseInt(in.readLine());
                Student studentToChange = studentList.getAllStudents().get(studId);
                out.write("Введите фамилию и имя студента:" + "\n");
                out.flush();
                String name = in.readLine();
                out.write("Введите курс студента(1-5):" + "\n");
                out.flush();
                int course = Integer.parseInt(in.readLine());
                out.write("Введите номер группы студента:" + "\n");
                out.flush();
                int group = Integer.parseInt(in.readLine());
                out.write("Введите факультет(ECONOMICS, ENGINEER, BIOLOGY, PHYSICS):" + "\n");
                out.flush();
                Faculty faculty = Faculty.valueOf(in.readLine());
                studentList.changeStudentData(studentToChange, name, course, group, faculty);
                break;
            case "6":
            default:
                break;
        }
        return result;
    }
    private static Student studentInit() throws IOException {
        int size = studentList.getAllStudents().size();
        int id = studentList.getAllStudents().get(size-1).getId();
        out.write("Введите фамилию и имя студента:" + "\n");
        out.flush();
        String name = in.readLine();
        out.write("Введите курс студента(1-5):" + "\n");
        out.flush();
        int course = Integer.parseInt(in.readLine());
        out.write("Введите номер группы студента:" + "\n");
        out.flush();
        int group = Integer.parseInt(in.readLine());
        out.write("Введите факультет(ECONOMICS, ENGINEER, BIOLOGY, PHYSICS):" + "\n");
        out.flush();
        Faculty faculty = Faculty.valueOf(in.readLine());
        return new Student(++id, name, course, group, faculty);
    }
}