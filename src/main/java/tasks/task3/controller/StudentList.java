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

    public StudentList getInstance() {
        return getFromXml();
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

    public static void addToXml(Student student) {
        if(!studentList.students.isEmpty()) {
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

    public List<Student> getStudentByName(String name) {
        List<Student> result;
        if (name != null) {
            result = studentList.getAllStudents().stream()
                    .filter(student -> student.getName().contains(name))
                    .collect(Collectors.toList());
            if (result.isEmpty()) {
                System.out.println("Таких студентов нет");
            }
        } else throw new IllegalArgumentException("Задано неверное имя.");
        return result;
    }

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

    public void addStudent(String name, int course, int group, Faculty faculty) {
        if (name != null && course >= 1 && course <= 5 && group > 0 && faculty != null) {
//            studentList.getAllStudents().add(new Student(name, course, group, faculty));
        } else {
            throw new IllegalArgumentException("Заданы некорректные данные при добавлении студента.");
        }
    }
    public String response(List<Student> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(student -> sb.append(student).append("\n"));
        return sb.toString();
    }

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