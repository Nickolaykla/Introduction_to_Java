package tasks.task3.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "course", "group", "faculty"})
public class Student {
    private String name;
    private int course;
    private int group;
    private Faculty faculty;

    public Student(String name, int course, int group, Faculty faculty) {
        if (name != null && group > 0 && course >= 1 && course <= 5 && faculty != null) {
            this.name = name;
            this.course = course;
            this.group = group;
            this.faculty = faculty;
        } else throw new IllegalArgumentException("Введены некорректные данные");
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else throw new IllegalArgumentException("Ошибка ввода имени");
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        if (group > 0) {
            this.group = group;
        } else throw new IllegalArgumentException("Ошибка ввода номера группы");
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course >= 1 && course <= 5) {
            this.course = course;
        } else throw new IllegalArgumentException("Неверное задан номер курса.");
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        if (faculty != null) {
            this.faculty = faculty;
        } else throw new IllegalArgumentException("Неверное задан факультет.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", group=" + group +
                ", faculty=" + faculty +
                '}';
    }
}