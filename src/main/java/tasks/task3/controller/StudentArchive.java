package tasks.task3.controller;

import tasks.task3.model.Faculty;
import tasks.task3.model.Student;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@XmlRootElement(name = "students")
public class StudentArchive {
    private static final String PATH =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task3/data/students.xml";
    private static StudentArchive studentList = new StudentArchive();

    @XmlElement(name = "student")
    private List<Student> students = new ArrayList<>();

    public StudentArchive() {
    }

    public static StudentArchive getStudentList() {
        return studentList;
    }

    public List<Student> getAllStudents() {
        return getFromXml().students;
    }

    //считываем данные из xml
    public static StudentArchive getFromXml() {
        try (FileReader fr = new FileReader(PATH)) {
            JAXBContext context = JAXBContext.newInstance(StudentArchive.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (StudentArchive) unmarshaller.unmarshal(fr);
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serialize() {
        try (FileWriter fw = new FileWriter(PATH)) {
            JAXBContext jaxb = JAXBContext.newInstance(StudentArchive.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(studentList, fw);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // для обновления студента в архиве
    public void addToXml(int id, Student student) {
        studentList = getFromXml();
        studentList.students.add(id, student);
        serialize();
    }

    // добавление студента
    public void addToArchive(Student student) {
        studentList = getFromXml();
        studentList.students.add(student);
        serialize();
    }

    // получаем студентов по заданному курсу
    public List<Student> getStudentsByCourse(int course) {
        List<Student> result = new ArrayList<>();
        if (course >= 1 && course <= 5) {
            result = studentList.getAllStudents().stream()
                    .filter(student -> student.getCourse() == course)
                    .collect(Collectors.toList());
        }
        return result;
    }

    public void deleteStudent(int id) {
        studentList = getFromXml();
        studentList.students.remove(id - 1);
        serialize();
    }

    //получаем студентов по заданной группе
    public List<Student> getStudentsByGroup(int group) {
        List<Student> result = new ArrayList<>();
        if (group > 0) {
            result = studentList.getAllStudents().stream()
                    .filter(student -> student.getGroup() == group)
                    .collect(Collectors.toList());
        }
        return result;
    }

    // получаем студентов по заданному факультету
    public List<Student> getStudentsByFaculty(Faculty faculty) {
        List<Student> result = new ArrayList<>();
        if (faculty != null) {
            result = studentList.getAllStudents().stream()
                    .filter(student -> student.getFaculty().equals(faculty))
                    .collect(Collectors.toList());
        }
        return result;
    }

    // перевод результата в строковый вид
    public String response(List<Student> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(student -> sb.append(student).append("\n"));
        return sb.toString();
    }

    // изменение данных студента
    public Student changeStudentData(Student student, int id, String name, int course, int group, Faculty faculty) {
        student.setName(name);
        student.setCourse(course);
        student.setGroup(group);
        student.setFaculty(faculty);
        deleteStudent(id + 1);
        addToXml(id, student);
        return student;
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