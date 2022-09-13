package tasks.task3.data;

import tasks.task3.model.Faculty;
import tasks.task3.model.Student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

import static tasks.task3.model.Faculty.*;

@XmlRootElement
public class StudentList {
    @XmlElementWrapper(name = "students", nillable = true)
    @XmlElement(name = "student")
    public
    List<Student> students = new ArrayList<>();
    {
        students.add(new Student("Васильев А.А.", 1, 10, ECONOMICS));
        students.add(new Student("Иванов В.У.", 2, 11, PHYSICS));
        students.add(new Student("Петрова Н.С.", 3, 12, BIOLOGY));
        students.add(new Student("Скворцова Д.П.", 5, 13, ENGINEER));
        students.add(new Student("Воробьев В.В.", 4, 14, ENGINEER));
    }
}
