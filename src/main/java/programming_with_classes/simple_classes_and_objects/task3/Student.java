package programming_with_classes.simple_classes_and_objects.task3;

import java.util.Arrays;

/*
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы,
успеваемость(массив из пяти элементов). Создайте массив из десяти элементов такого типа.
Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные 9 или 10.
*/
public class Student {
    private String name;
    private int groupNum;
    private int[] GPA = new int[5];

    public Student(String name, int groupNum, int[] GPA) {
        if (!name.isEmpty() && groupNum > 0 && GPA != null) {
            this.name = name;
            this.groupNum = groupNum;
            this.GPA = GPA;
        } else throw new IllegalArgumentException();
    }

    public Student() {
    }

    // Находим студентов с указанными оценками
    public Student[] getStudentsWithMaxGPA(Student[] students) {
        if (students != null) {
            return Arrays.stream(students)
                    .filter(student -> checkForMaxGPA(student.getGPA()))
                    .toArray(Student[]::new);
        } else throw new IllegalArgumentException("Передан пустой массив студентов");
    }

    // Проверяем все ли оценки больше либо равны 9;
    public boolean checkForMaxGPA(int[] GPA) {
        if (GPA != null) {
            return Arrays.stream(GPA).allMatch(i -> i >= 9);
        } else throw new IllegalArgumentException("Передан пустой массив GPA");
    }

    public int[] getGPA() {
        return GPA;
    }

    public void setGPA(int[] GPA) {
        if (GPA != null) {
            this.GPA = GPA;
        } else throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else throw new IllegalArgumentException();
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        if (groupNum > 0) {
            this.groupNum = groupNum;
        } else throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name +
                ", groupNum=" + groupNum +
                ", GPA=" + Arrays.toString(getGPA()) +
                "}";
    }
}