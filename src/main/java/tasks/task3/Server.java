package tasks.task3;

/*
Создайте клиент-серверное приложение "Архив".
 */

import tasks.task3.controller.StudentArchive;
import tasks.task3.controller.UserLogging;
import tasks.task3.model.Faculty;
import tasks.task3.model.Role;
import tasks.task3.model.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    static BufferedReader in;
    static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(4004);
             Socket serverSocket = server.accept()) {

            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
            Server serv = new Server();

            // Просим пользователя выбрать действие из стартового меню
            String requestLogin = in.readLine();
            while (!serv.loginResponse(requestLogin)) {
                requestLogin = in.readLine();
                serv.loginResponse(requestLogin);
            }

            String request = "";
            String result = "";
            while (serverSocket.isConnected()) {
                request = in.readLine();
                if (request.equalsIgnoreCase("exit")){
                    break;
                }

                if (UserLogging.getRole().equals(Role.ADMIN)) {
                    result = serv.doAdminResponse(request);
                } else result = serv.doUserResponse(request);

                out.write(result + "\n");
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean loginResponse(String param) throws IOException {
        boolean resultOfLogging = false;
        switch (param) {
            case "1":
               if(UserLogging.logIn(in, out)) {
                   resultOfLogging = true;
               }
                break;
            case "2":
               UserLogging.register(in, out);
               resultOfLogging = true;
                break;
            default:
                out.write("Неверный параметр" + "\n");
                out.write(Client.startMenu() + "\n");
                out.flush();
                break;
        }
        return resultOfLogging;
    }

    public String doUserResponse(String param) throws IOException {
        String result = "";
        switch (param) {
            case "1":
                result = showAllStudents();
                break;
            case "2":
                result = showStudentsByFaculty();
                break;
            case "3":
                result = showStudentsByCourse();
                break;
            default:
                out.write("Задан неверный запрос" + "\n");
                out.flush();
                break;
        }
        return result;
    }

    public String doAdminResponse(String param) throws IOException {
        String result = "";
        switch (param) {
            case "1":
                result = showAllStudents();
                break;
            case "2":
                result = showStudentsByFaculty();
                break;
            case "3":
                result = showStudentsByCourse();
                break;
            case "4":
                out.write("Введите номер группы для получения дел студентов:" + "\n");
                out.flush();
                int groupNum = Integer.parseInt(in.readLine());
                List<Student> res7 = StudentArchive.getStudentList().getStudentsByGroup(groupNum);
                result = StudentArchive.getStudentList().response(res7);
                badResponse(result);
                break;
            case "5":
                out.write("Введите id студента:" + "\n");
                out.flush();
                int studId = Integer.parseInt(in.readLine());
                Student studentToChange = StudentArchive.getStudentList().getAllStudents().get(studId - 1);
                System.out.println(studentToChange);
                out.write("Введите имя и фамилию студента:" + "\n");
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
                result = StudentArchive.getStudentList().changeStudentData
                        (studentToChange, studId - 1, name, course, group, faculty).toString();
                break;
            case "6":
                out.write("Введите id студента для удаления дела:" + "\n");
                out.flush();
                int id = Integer.parseInt(in.readLine());
                StudentArchive.getStudentList().deleteStudent(id);
                break;
            case "7":
                Student newStud = studentInit();
                StudentArchive.getStudentList().addToArchive(newStud);
                break;
            default:
                out.write("Задан неверный запрос" + "\n");
                out.flush();
                break;
        }
        return result;
    }

    private static void badResponse(String response) {
        if (response.isEmpty()) {
            try {
                out.write("По данному запросу ничего не найдено" + "\n");
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String showAllStudents() {
        List<Student> res1 = StudentArchive.getStudentList().getAllStudents();
        String result = StudentArchive.getStudentList().response(res1);
        badResponse(result);
        return result;
    }

    private String showStudentsByFaculty() {
        try {
            out.write("Введите факультет(ECONOMICS, ENGINEER, BIOLOGY, PHYSICS:" + "\n");
            out.flush();
            List<Student> res2 = StudentArchive.getStudentList().getStudentsByFaculty(Faculty.valueOf(in.readLine()));
            String result = StudentArchive.getStudentList().response(res2);
            badResponse(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String showStudentsByCourse() {
        try {
            out.write("Введите курс (1-5):" + "\n");
            out.flush();
            List<Student> res3 = StudentArchive.getStudentList().getStudentsByCourse(Integer.parseInt(in.readLine()));
            String result = StudentArchive.getStudentList().response(res3);
            badResponse(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // метод для создания дела студента
    private static Student studentInit() throws IOException {
        int size = StudentArchive.getStudentList().getAllStudents().size();
        int id = StudentArchive.getStudentList().getAllStudents().get(size - 1).getId();
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