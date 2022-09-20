package tasks.task3.controller;

import tasks.task3.model.Faculty;
import tasks.task3.model.Student;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@XmlRootElement(name = "students")
public class StudentList {
    private static final String PATH =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task3/data/students.xml";
    private static StudentList studentList = new StudentList();

    @XmlElement(name = "student")
    private List<Student> students = new ArrayList<>();

    public StudentList() {
    }

    public boolean add(Student stud) {
        return students.add(stud);
    }

    public List<Student> getAllStudents() {
        return getFromXml().students;
    }

    public static StudentList getFromXml() {
        try (FileReader fr = new FileReader(PATH)) {
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (StudentList) unmarshaller.unmarshal(fr);
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    // добавляем студента в архив
    public static void addToXml(Student student) {
        if(!getFromXml().students.isEmpty()) {
            studentList = getFromXml();
            studentList.add(student);
        } else studentList.add(student);

        try (FileWriter fw = new FileWriter(PATH)) {
            JAXBContext jaxb = JAXBContext.newInstance(StudentList.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(studentList, fw);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // получаем студентов по заданному курсу
    public List<Student> getStudentsByCourse(int course) {
        List<Student> result;
        if (course >= 1 && course <= 5) {
            result = studentList.getAllStudents().stream()
                    .filter(student -> student.getCourse() == course)
                    .collect(Collectors.toList());
            if (result.isEmpty()) {
                System.out.println("Таких студентов нет");
            }
        } else throw new IllegalArgumentException("Курс должен находиться в диапазоне от 1 до 5");
        return result;
    }

    public void deleteStudent(int id) {
        studentList.getAllStudents().remove(id);
    }

    //получаем студентов по заданной группе
    public List<Student> getStudentsByGroup(int group) {
        List<Student> result;
        if (group > 0) {
            result = studentList.getAllStudents().stream()
                    .filter(student -> student.getGroup() == group)
                    .collect(Collectors.toList());
            if (result.isEmpty()) {
                System.out.println("Таких студентов нет");
            }
        } else throw new IllegalArgumentException("Номер группы не может быть отрицательным");
        return result;
    }

    // получаем студентов по заданному факультету
    public List<Student> getStudentsByFaculty(Faculty faculty) {
        List<Student> result;
        if (faculty != null) {
            result = studentList.getAllStudents().stream()
                    .filter(student -> student.getFaculty().equals(faculty))
                    .collect(Collectors.toList());
            if (result.isEmpty()) {
                System.out.println("Студентов на данном факультете нет.");
            }
        } else throw new IllegalArgumentException("Задан неверный факультет.");
        return result;
    }

    // перевод результата в строковый вид
    public String response(List<Student> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(student -> sb.append(student).append("\n"));
        return sb.toString();
    }

    // изменение данных студента
    public void changeStudentData(Student student, String name, int course, int group, Faculty faculty) {
        student.setName(name);
        student.setCourse(course);
        student.setGroup(group);
        student.setFaculty(faculty);

        studentList.getAllStudents().add(student);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student st : students) {
            sb.append(st).append("\n");
        }
        return sb.toString();
    }
}