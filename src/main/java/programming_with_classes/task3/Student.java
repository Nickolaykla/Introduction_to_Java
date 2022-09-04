package programming_with_classes.task3;

import java.util.Arrays;

/*
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы,
успеваемость(массив из пяти элементов). Создайте массив из десяти элементов такого типа.
Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные 9 или 10.
* */
public class Student {
    private String name;
    private int groupNum;
    private int[] GPA = new int[5];

    public Student(String name, int groupNum) {
        if (!name.isEmpty() && groupNum > 0) {
            this.name = name;
            this.groupNum = groupNum;
        } else throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println("Студенты с оценками 9 или 10:");
        getStudentsWithMaxGPA(initStudentArrayAndSetGPA());
    }

    // Находим студентов с указанными оценками
    public static void getStudentsWithMaxGPA(Student[] students) {
        Arrays.stream(students)
                .filter(student -> checkForMaxGPA(student.getGPA()))
                .forEach(System.out::println);
    }

    // Проверяем все ли оценки больше либо равны 9;
    public static boolean checkForMaxGPA(int[] GPA) {
        return Arrays.stream(GPA).allMatch(i -> i >= 9);
    }

    // Добавляем созданных студентов в массив. Устанавливаем успеваемость для каждого студента.
    public static Student[] initStudentArrayAndSetGPA() {
        Student student1 = new Student("Васильков Д.В.", 112);
        Student student2 = new Student("Петров А.С.", 112);
        Student student3 = new Student("Иванова Н.П.", 113);
        Student student4 = new Student("Соколова С.С.", 113);
        Student student5 = new Student("Меньшиков О.Е.", 111);
        Student student6 = new Student("Сидоров С.И.", 111);
        Student student7 = new Student("Камышов И.Л.", 112);
        Student student8 = new Student("Деточкина Д.С.", 113);
        Student student9 = new Student("Корнилова Е.Е.", 111);
        Student student10 = new Student("Ситников Ф.Ф.", 112);

        student1.setGPA(new int[]{7, 6, 5, 7, 6});
        student2.setGPA(new int[]{8, 8, 9, 10, 9});
        student3.setGPA(new int[]{7, 7, 8, 7, 7});
        student4.setGPA(new int[]{9, 10, 10, 10, 10});
        student5.setGPA(new int[]{4, 5, 3, 5, 4});
        student6.setGPA(new int[]{10, 9, 9, 9, 9});
        student7.setGPA(new int[]{8, 8, 8, 7, 7});
        student8.setGPA(new int[]{6, 6, 5, 6, 6});
        student9.setGPA(new int[]{10, 10, 9, 9, 10});
        student10.setGPA(new int[]{9, 9, 10, 9, 10});

        return new Student[]{
                student1, student2, student3, student4, student5,
                student6, student7, student8, student9, student10};
    }

    public int[] getGPA() {
        return GPA;
    }

    public void setGPA(int[] GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupNum=" + groupNum +
                '}';
    }
}
