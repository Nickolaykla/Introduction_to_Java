package tasks.task3;

/*
Создайте клиент-серверное приложение "Архив".
 */

import tasks.task3.controller.StudentArchive;
import tasks.task3.model.Faculty;
import tasks.task3.model.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    static StudentArchive studentArchive = new StudentArchive();
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
                if(request.equalsIgnoreCase("exit")) break;

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
                List<Student> res1 = studentArchive.getAllStudents();
                result = studentArchive.response(res1);
                break;
            case "2":
                out.write("Введите факультет(ECONOMICS, ENGINEER, BIOLOGY, PHYSICS:" + "\n");
                out.flush();
                List<Student> res2 = studentArchive.getStudentsByFaculty(Faculty.valueOf(in.readLine()));
                result = studentArchive.response(res2);
                break;
            case "3":
                out.write("Введите курс (1-5):" + "\n");
                out.flush();
                List<Student> res3 = studentArchive.getStudentsByCourse(Integer.parseInt(in.readLine()));
                result = studentArchive.response(res3);
                break;
            case "4":
                Student newStud = studentInit();
                StudentArchive.addToXml(newStud);
                break;
            case "5":
                out.write("Введите id студента:");
                out.flush();
                int studId = Integer.parseInt(in.readLine());
                Student studentToChange = studentArchive.getAllStudents().get(studId);
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
                studentArchive.changeStudentData(studentToChange, name, course, group, faculty);
                break;
            case "6":
                out.write("Введите id студента для удаления дела:" + "\n");
                out.flush();
                int id = Integer.parseInt(in.readLine());
                studentArchive.deleteStudent(id);
                break;
            case "7":
                out.write("Введите номер группы для получения дел студентов:" + "\n");
                out.flush();
                int groupNum = Integer.parseInt(in.readLine());
                List<Student> res7 = studentArchive.getStudentsByGroup(groupNum);
                result = studentArchive.response(res7);
                break;
            default:
                out.write("Задан неверный запрос" + "\n");
                out.flush();
                break;
        }
        return result;
    }

    private static Student studentInit() throws IOException {
        int size = studentArchive.getAllStudents().size();
        int id = studentArchive.getAllStudents().get(size - 1).getId();
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