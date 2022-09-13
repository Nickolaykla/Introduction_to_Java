package tasks.task3.controller;

import tasks.task3.data.StudentList;
import tasks.task3.model.Faculty;
import tasks.task3.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Archive {
   StudentList studentList = new StudentList();

    public String getStudentList() {
        StringBuilder sb = new StringBuilder();
        for (Student student : studentList.students) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }

    public List<Student> getStudentByName(String name) {
        List<Student> result;
        if (name != null) {
            result = studentList.students.stream()
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
            result = studentList.students.stream()
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
            result = studentList.students.stream()
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
            result = studentList.students.stream()
                    .filter(student -> student.getFaculty() == faculty)
                    .collect(Collectors.toList());
            if (result.isEmpty()) {
                System.out.println("Студентов на данном факультете нет.");
            }
        } else throw new IllegalArgumentException("Задан неверный факультет.");
        return result;
    }

    public void addStudent(String name, int course, int group, Faculty faculty) {
        if (name != null && course >= 1 && course <= 5 && group > 0 && faculty != null) {
            studentList.students.add(new Student(name, course, group, faculty));
        } else {
            throw new IllegalArgumentException("Заданы некорректные данные при добавлении студента.");
        }
    }

    public void changeStudentData(String name, int course, int group, Faculty faculty) {
        Student student = new Student();
        student.setName(name);
        student.setCourse(course);
        student.setGroup(group);
        student.setFaculty(faculty);

        studentList.students.add(student);
    }
}